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

    @GetMapping("services/users")
    public String getUser(Model model) {
        List<User> users = userService.getSinger();
        model.addAttribute("users", users);
        return "services";
    }

    @PostMapping("services/addNewUser")
    public String addNew(User user){
        userService.save(user);
        return "redirect:/services";
    }

    @RequestMapping(value = "services/updateUser", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(User user) {
        userService.save(user);
        return "redirect:/services";
    }

    @RequestMapping(value = "services/deleteUser", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/services";
    }

    @GetMapping("services/findByIdUser")
    public Optional<User> findById(Long id) {
        return userService.findById(id);
    }
}
