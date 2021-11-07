package com.hamed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hamed.model.Singer;

@Repository
public interface SingerRepository extends JpaRepository<Singer, Long>{

}
