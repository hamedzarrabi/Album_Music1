package com.hamed.service;

import com.hamed.model.Genre;
import com.hamed.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    // insert and update in database
    public void save(Genre genre) {
        genreRepository.save(genre);
    }

    // find id from database
    public Optional<Genre> findById(Long id) {
        return genreRepository.findById(id);
    }

    // delete from database with id
    public void delete(Long id) {
        genreRepository.deleteById(id);
    }

    // find all albums
    public List<Genre> getGenre() {
        return genreRepository.findAll();
    }
}
