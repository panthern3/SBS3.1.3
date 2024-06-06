package ru.kata.spring.boot_security.demo.example.controller;

import ru.kata.spring.boot_security.demo.example.model.User;
import ru.kata.spring.boot_security.demo.example.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user-home")
public class UserHomeController {

    private final UserService userService;

    public UserHomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUserHome(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        User user = userService.findByEmail(email);
        model.addAttribute("user", user);
        return "user-home";
    }
}
