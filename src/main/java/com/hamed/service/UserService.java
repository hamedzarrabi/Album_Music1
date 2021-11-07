package com.hamed.service;

import com.hamed.model.User;
import com.hamed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // insert and update in database
    public void save(User user) {
        userRepository.save(user);
    }

    // find id from database
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    // delete from database with id
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    // find all albums
    public List<User> getSinger() {
        return userRepository.findAll();
    }
}
