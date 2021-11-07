package com.hamed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hamed.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

}
