package com.hamed.service;

import com.hamed.model.Singer;
import com.hamed.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SingerService {

    @Autowired private SingerRepository singerRepository;

    // insert and update in database
    public void save(Singer singer) {
        singerRepository.save(singer);
    }

    // find id from database
    public Optional<Singer> findById(Long id) {
        return singerRepository.findById(id);
    }

    // delete from database with id
    public void delete(Long id) {
        singerRepository.deleteById(id);
    }

    // find all albums
    public List<Singer> getSinger() {
        return singerRepository.findAll();
    }
}
