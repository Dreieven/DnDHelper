package com.org.DnDHelper.configurations.security;

import com.org.DnDHelper.configurations.annotations.ValidEmail;
import com.org.DnDHelper.exceptions.UserAlreadyExistsException;
import com.org.DnDHelper.messages.RegisterUserRequest;
import com.org.DnDHelper.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.RoleNotFoundException;

@RestController
@RequestMapping("/auth/")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public String registerUser(@Valid @RequestBody RegisterUserRequest registerUserRequest) throws UserAlreadyExistsException, RoleNotFoundException {
        authService.registerUser(registerUserRequest);
        return "Registered " + registerUserRequest.getName();
    }
}