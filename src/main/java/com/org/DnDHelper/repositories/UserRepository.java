package com.org.DnDHelper.repositories;

import com.org.DnDHelper.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByAuthUserMail(String authUsername);

}
