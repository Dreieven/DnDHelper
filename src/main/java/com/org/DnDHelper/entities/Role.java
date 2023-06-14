package com.org.DnDHelper.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue
    Integer id;

    String name;

    @ManyToMany(mappedBy = "roles")
    Set<AuthUser> authUser;
}