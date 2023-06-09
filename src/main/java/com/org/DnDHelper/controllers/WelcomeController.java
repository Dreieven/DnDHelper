package com.org.DnDHelper.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('admin')")
    public String adminPanel() {
        return "adminPanel";
    }
}
