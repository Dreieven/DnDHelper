package com.org.DnDHelper.controllers;

import com.org.DnDHelper.entities.User;
import com.org.DnDHelper.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserManagementController {

    UserService userService;
    @Autowired
    public UserManagementController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    @PreAuthorize("hasRole('admin')")
    public User getUser() {
        return new User();
    }

    @GetMapping("/test")
    public void req(HttpServletRequest request, HttpServletResponse response) {

    }
}
