package com.hamed.controller;

import com.hamed.model.User;
import com.hamed.service.UserService;
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
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("services_user")
    public String getUser(Model model) {
        List<User> users = userService.listAll();
        model.addAttribute("users", users);
        return "services_user";
    }

    @PostMapping("services_user/addNewUser")
    public String addNew(User user){
        userService.saveUserWithDefaultRole(user);
        return "redirect:/services_user";
    }

    @RequestMapping(value = "services_user/updateUser", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(User user) {
        userService.save(user);
        return "redirect:/services_user";
    }

    @RequestMapping(value = "services_user/deleteUser", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/services_user";
    }

    @GetMapping("services_user/findByIdUser")
    public Optional<User> findById(Long id) {
        return userService.findById(id);
    }
}
