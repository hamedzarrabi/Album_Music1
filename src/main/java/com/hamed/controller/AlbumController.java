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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AlbumController {

    @Autowired private AlbumService albumService;
    @Autowired private GenreService genreService;
    @Autowired private SingerService singerService;

    @PostMapping("/services_album/addNewAlbum")
    public String addNew(Album album) {
        albumService.save(album);
        return "redirect:/services_album";
    }

    @RequestMapping (value = "/services_album/deleteAlbum", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        albumService.delete(id);
        return "redirect:/services_album";
    }

    @RequestMapping(value = "services_album/updateAlbum", method = {RequestMethod.PUT, RequestMethod.GET})
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
}
