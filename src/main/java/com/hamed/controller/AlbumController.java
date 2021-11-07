package com.hamed.controller;

import com.hamed.model.Album;
import com.hamed.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AlbumController {

    @Autowired private AlbumService albumService;

    @PostMapping("/services/addNewAlbum")
    public String addNew(Album album) {
        albumService.save(album);
        return "redirect:/services";
    }

    @RequestMapping (value = "/services/deleteAlbum", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        albumService.delete(id);
        return "redirect:/services";
    }

    @RequestMapping(value = "services/updateAlbum", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Album album) {
        albumService.save(album);
        return "redirect:/services";
    }

    @RequestMapping(value = "services/findByIdAlbum")
    @ResponseBody
    public Optional<Album> findById(Long id) {
        return albumService.findById(id);
    }

    @GetMapping(value = "services/albums")
    public String getAlbums(Model model) {
        List<Album> albums = albumService.getAlbum();
        model.addAttribute("albums", albums);
        return "services_album";
    }


}
