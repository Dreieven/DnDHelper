package com.org.DnDHelper.services;

import com.org.DnDHelper.entities.AuthUser;
import com.org.DnDHelper.entities.User;
import com.org.DnDHelper.exceptions.UserAlreadyExistsException;
import com.org.DnDHelper.messages.RegisterUserRequest;
import com.org.DnDHelper.repositories.AuthUserRepository;
import com.org.DnDHelper.repositories.RoleRepository;
import com.org.DnDHelper.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    AuthUserRepository authUserRepository;
    @Autowired
    UserRepository userRepository;
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
        authUserRepository.save(authUser);
        userRepository.save(User.builder()
                .authUserMail(userRequest.getEmail())
                .build());
        return authUser;
    }

    public boolean emailExists(String email) {
        return authUserRepository.findByEmail(email).isPresent();
    }
}
