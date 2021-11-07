package com.hamed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hamed.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
