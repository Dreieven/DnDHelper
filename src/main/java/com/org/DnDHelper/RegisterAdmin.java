package com.org.DnDHelper;

import com.org.DnDHelper.entities.AuthUser;
import com.org.DnDHelper.exceptions.UserAlreadyExistsException;
import com.org.DnDHelper.messages.RegisterUserRequest;
import com.org.DnDHelper.services.AuthService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.relation.RoleNotFoundException;

@Component
public class RegisterAdmin {

    @Autowired
    AuthService authService;

    @PostConstruct
    private void createAdmin() throws UserAlreadyExistsException, RoleNotFoundException {
        if (!authService.emailExists("admin@mail.com")) {
            RegisterUserRequest registerRequest = new RegisterUserRequest("admin", "admin@mail.com", "admin");
            AuthUser user = authService.registerUser(registerRequest, "admin");
            System.out.println("Created admin");
        }
    }
}
