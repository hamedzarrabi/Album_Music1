package com.hamed.controller;

import com.hamed.model.Album;
import com.hamed.model.Order;
import com.hamed.service.AlbumService;
import com.hamed.service.OrderService;
import com.hamed.service.SingerService;
import com.hamed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class OrderController {

    @Autowired private OrderService orderService;
    @Autowired private AlbumService albumService;
    @Autowired private SingerService singerService;
    @Autowired private UserService userService;

    @PostMapping("/order/save")
    public String save(Order order) {

        orderService.save(order);
        return "redirect:/cart";
    }

    @GetMapping("/order/findById")
    public Optional<Order> findById(Long id) {
        return orderService.findById(id);
    }

    @GetMapping("/order/edit")
    public String showOrderForm() {

//        Album orderAlbum = albumService.getAlbum().get(id);

//        model.addAttribute("orderAlbum", orderAlbum);
        return "cart";
    }

    @GetMapping("/order/delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        orderService.delete(id);

        return "redirect:/cart";
    }

    @GetMapping("/order")
    public String getMusic(Model model) {

        model.addAttribute("albumService", albumService.getAlbum());
        model.addAttribute("singerService", singerService.getSinger());
        model.addAttribute("userService", userService.listAll());
        model.addAttribute("orders", orderService.getOrder());

        return "cart";
    }

    @RequestMapping("/cartview")
    public String showAlbumSession(@ModelAttribute Album album, Model model) {

        model.addAttribute("cart", albumService.getAlbum());

        return "cart";
    }
}
