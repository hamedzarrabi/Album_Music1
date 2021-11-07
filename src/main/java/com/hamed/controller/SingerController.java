package com.hamed.controller;

import com.hamed.model.Singer;
import com.hamed.service.SingerService;
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
public class SingerController {

    @Autowired private SingerService singerService;

    @PostMapping(value = "services/addNewSinger")
    public String addNew(Singer singer) {
        singerService.save(singer);
        return "redirect:/services";
    }

    @RequestMapping(value = "services/updateSingers", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Singer singer){
        singerService.save(singer);
        return "redirect:/services";
    }

    @RequestMapping(value = "services/deleteSinger", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        singerService.delete(id);
        return "redirect:/services";
    }

    @GetMapping("services/findByIdSinger")
    public Optional<Singer> findById(Long id) {
        return singerService.findById(id);
    }

    @GetMapping(value = "services/singers")
    public String getSingers(Model model) {
        List<Singer> singers = singerService.getSinger();
        model.addAttribute("singers", singers);
        return "services_album";
    }


}
