package com.hamed.controller;

import com.hamed.model.Album;
import com.hamed.model.Genre;
import com.hamed.model.Singer;
import com.hamed.service.AlbumService;
import com.hamed.service.GenreService;
import com.hamed.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class AlbumController {

    @Autowired private AlbumService albumService;
    @Autowired private GenreService genreService;
    @Autowired private SingerService singerService;


    @PostMapping("services_album/addNew")
    public String addNew(@RequestParam("music")MultipartFile multipartFile,Album album, RedirectAttributes redirectAttributes) throws IOException {


        String baseDir = "src/main/resources/static/assets/upload/";
        Path path = Paths.get(baseDir + multipartFile.getOriginalFilename());
        Files.write(path, multipartFile.getBytes());

        album.setMusic_album("assets/upload/" + multipartFile.getOriginalFilename());
        album.setSize(multipartFile.getSize());


        albumService.save(album);

        redirectAttributes.addFlashAttribute("message", "The Album been uploaded successfully.");
        return "redirect:/services_album";
    }

    @RequestMapping (value = "/services_album/deleteAlbum", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) throws IOException {

//        Path path = Paths.get(album.getMusic_album());
//        Files.delete(path);
        albumService.delete(id);

        return "redirect:/services_album";
    }

    @RequestMapping(value = "/services_album/update", method = {RequestMethod.PUT, RequestMethod.GET})
    @ResponseBody
    public String update(Album album) {
        albumService.save(album);
        return "redirect:/services_album";
    }

    @RequestMapping(value = "services_album/findByIdAlbum")
    @ResponseBody
    public Optional<Album> findById(Long id) {
        return albumService.findById(id);
    }

    @GetMapping(value = "services_album")
    public String getAlbums(Model model) {

        List<Album> albums = albumService.getAlbum();
        List<Genre> genres = genreService.getGenre();
        List<Singer> singers = singerService.getSinger();

        model.addAttribute("albums", albums);
        model.addAttribute("genres", genres);
        model.addAttribute("singers", singers);

        return "services_album";
    }

    @ModelAttribute(name = "cart")
    @PostMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cart", albumService.getAlbum());
        return "redirect:/cart";
    }

}
