package com.hamed.controller;

import com.hamed.model.Genre;
import com.hamed.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping(value = "services/addNewGenre")
    public String addNew(Genre genre) {
        genreService.save(genre);
        return "redirect:/services";
    }

    @RequestMapping(value = "services/updateGenre", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Genre genre){
        genreService.save(genre);
        return "redirect:/services";
    }

    @RequestMapping(value = "services/deleteGenre", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        genreService.delete(id);
        return "redirect:/services";
    }

    @GetMapping("services/findByIdGenre")
    public Optional<Genre> findById(Long id) {
        return genreService.findById(id);
    }

    @GetMapping(value = "services/genre")
    public String getGenres(Model model) {
        List<Genre> genres = genreService.getGenre();
        model.addAttribute("genres", genres);
        return "services_album";
    }
}
