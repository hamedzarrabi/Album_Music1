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
public class CustomerController {

    @Autowired private AlbumService albumService;
    @Autowired private GenreService genreService;
    @Autowired private SingerService singerService;


    @RequestMapping(value = "customer_album/findByIdAlbum")
    @ResponseBody
    public Optional<Album> findById(Long id) {
        return albumService.findById(id);
    }

    @GetMapping(value = "customer_album")
    public String getAlbums(Model model) {

        List<Album> albums = albumService.getAlbum();
        List<Genre> genres = genreService.getGenre();
        List<Singer> singers = singerService.getSinger();

        model.addAttribute("customer_album", albums);
        model.addAttribute("customer_genres", genres);
        model.addAttribute("customer_singers", singers);

        return "redirect:/customer_album";
    }

}
