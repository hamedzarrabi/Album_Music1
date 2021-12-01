package com.hamed.controller;

import com.hamed.model.Album;
import com.hamed.model.Votes;
import com.hamed.repository.VoteRepository;
import com.hamed.service.AlbumService;
import com.hamed.service.SingerService;
import com.hamed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class MusicController {

    @Autowired private AlbumService albumService;
    @Autowired private UserService userService;
    @Autowired private SingerService singerService;
    @Autowired private VoteRepository voteRepository;


    @GetMapping("/musics")
    public String getMusic(Model model) {

        model.addAttribute("albumService", albumService.getAlbum());
        model.addAttribute("singerService", singerService.getSinger());
        model.addAttribute("userService", userService.listAll());

        return "services_music_customer";
    }

    @GetMapping("/musics/findById/{id}")
    @ResponseBody
    public Optional<Album> findById(Long id) {
        return albumService.findById(id);
    }

    @GetMapping("/services_music_customer/save_vote")
    public String saveVote(Votes votes) {

        voteRepository.save(votes);
        return "redirect:/musics";
    }



}
