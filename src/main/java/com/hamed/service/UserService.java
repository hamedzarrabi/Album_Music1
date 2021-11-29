package com.hamed.service;

import com.hamed.model.Role;
import com.hamed.model.User;
import com.hamed.repository.RoleRepository;
import com.hamed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    // insert and update in database
    public void save(User user) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

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
    public List<User> listAll() {
        return userRepository.findAll();
    }

    public void saveUserWithDefaultRole(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Role roleUser = roleRepository.findByName("Customer");
        user.addRole(roleUser);

        userRepository.save(user);
    }



    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public User get(Long id) {
        return userRepository.findById(id).get();
    }

}
