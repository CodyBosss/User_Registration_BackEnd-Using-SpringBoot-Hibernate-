package com.codybosss.Dao;

import java.util.Optional;

import com.codybosss.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codybosss.entity.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}

