package com.hamed.service;

import com.hamed.model.Album;
import com.hamed.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired private AlbumRepository albumRepository;

    // insert and update in database
    public void save(Album album) {
        albumRepository.save(album);
    }

    // delete from database with id
    public void delete(Long id) {
        albumRepository.deleteById(id);
    }

    // find id from database
    public Optional<Album> findById(Long id) {
        return albumRepository.findById(id);
    }

    // find all albums
    public List<Album> getAlbum() {
        return albumRepository.findAll();
    }

}
