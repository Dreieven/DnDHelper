package com.org.DnDHelper.services;

import com.org.DnDHelper.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    @Autowired
    SessionRepository sessionRepository;

}
