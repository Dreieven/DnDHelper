package com.org.DnDHelper;

import com.org.DnDHelper.entities.AuthUser;
import com.org.DnDHelper.exceptions.UserAlreadyExistsException;
import com.org.DnDHelper.messages.RegisterUserRequest;
import com.org.DnDHelper.services.AuthService;
import com.org.DnDHelper.services.RoleService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.relation.RoleNotFoundException;

@Component
public class RegisterAdmin {

    @Autowired
    AuthService authService;

    @Autowired
    RoleService roleService;

    @PostConstruct
    private void createAdmin() throws UserAlreadyExistsException, RoleNotFoundException {
        if (!rolesExists()) {
            roleService.createRoles();
        }
        if (!authService.emailExists("admin@mail.com")) {
            RegisterUserRequest registerRequest = new RegisterUserRequest("admin", "admin@mail.com", "admin");
            AuthUser user = authService.registerUser(registerRequest, "ROLE_ADMIN");
        }
    }

    private boolean rolesExists() {
        return !roleService.getRoles().isEmpty();
    }
}
