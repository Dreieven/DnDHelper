package com.org.DnDHelper.services;

import com.org.DnDHelper.entities.User;
import com.org.DnDHelper.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


}
