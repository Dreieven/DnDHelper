package com.org.DnDHelper.services;

import com.org.DnDHelper.entities.AuthUser;
import com.org.DnDHelper.exceptions.UserAlreadyExistsException;
import com.org.DnDHelper.messages.RegisterUserRequest;
import com.org.DnDHelper.repositories.AuthUserRepository;
import com.org.DnDHelper.repositories.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

@Service
public class AuthService {
    @Autowired
    AuthUserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public AuthUser registerUser(RegisterUserRequest userRequest) throws UserAlreadyExistsException, RoleNotFoundException {
        return registerUser(userRequest, "player");
    }
    @Transactional(value = Transactional.TxType.REQUIRED)
    public AuthUser registerUser(RegisterUserRequest userRequest, String roleName) throws UserAlreadyExistsException, RoleNotFoundException {
        if (emailExists(userRequest.getEmail())) {
            throw new UserAlreadyExistsException("There is already account with this username " + userRequest.getEmail());
        }
        AuthUser authUser = AuthUser.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .roles(List.of(roleRepository.findByName(roleName).orElseThrow(() -> new RoleNotFoundException("There is no role "+ roleName))))
                .build();
        userRepository.save(authUser);
        return authUser;
    }

    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
