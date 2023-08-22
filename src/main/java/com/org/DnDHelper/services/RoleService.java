package com.org.DnDHelper.services;

import com.org.DnDHelper.entities.Role;
import com.org.DnDHelper.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public void createRoles() {
        List<Role> roles = new ArrayList<>();
        roles.add(Role.builder()
                .id(1)
                .name("ROLE_ADMIN")
                .build());
        roles.add(Role.builder()
                        .id(2)
                        .name("ROLE_GAME_MASTER")
                .build());
        roles.add(Role.builder()
                        .id(3)
                        .name("ROLE_PLAYER")
                .build());
        roleRepository.saveAll(roles);
    }

}
