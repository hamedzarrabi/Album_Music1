package com.hamed.controller;

import com.hamed.model.Genre;
import com.hamed.model.Singer;
import com.hamed.service.GenreService;
import com.hamed.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class SingerController {

    @Autowired private SingerService singerService;
    @Autowired private GenreService genreService;

    @PostMapping(value = "services_singer/addNew")
    public String addNew(Singer singer, RedirectAttributes redirectAttributes) {
        singerService.save(singer);
        redirectAttributes.addFlashAttribute("message", "The Singer been uploaded successfully.");
        return "redirect:/services_singer";
    }

    @RequestMapping(value = "services_singer/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Singer singer){
        singerService.save(singer);
        return "redirect:/services_singer";
    }

    @RequestMapping(value = "services_singer/deleteSinger/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable("id") Long id) {
        singerService.delete(id);
        return "redirect:/services_singer";
    }

    @GetMapping("services_singer/findById")
    @ResponseBody
    public Optional<Singer> findById(Long id) {
        return singerService.findById(id);
    }

    @GetMapping(value = "services_singer")
    public String getSingers(Model model) {
        List<Singer> singers = singerService.getSinger();
        List<Genre> genres = genreService.getGenre();

        model.addAttribute("singers", singers);
        model.addAttribute("genres", genres);

        return "services_singer";
    }


}
