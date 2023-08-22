package com.org.DnDHelper.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.org.DnDHelper.entities.User;
import com.org.DnDHelper.repositories.UserRepository;
import com.org.DnDHelper.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String welcome() {
        return "Welcome";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminPanel() {
        return "adminPanel";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login page";
    }

    @GetMapping("/player")
    @JsonView({UserView.Player.class})
    public User getPlayer(@RequestParam(name = "type") String username) {
        System.out.println(username);
        User user = userRepository.findByAuthUserMail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }

    @GetMapping("/gameMaster")
    @JsonView({UserView.GameMaster.class})
    public User getGM(@RequestParam(name = "type") String username) {
        System.out.println(username);
        return userRepository.findByAuthUserMail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
