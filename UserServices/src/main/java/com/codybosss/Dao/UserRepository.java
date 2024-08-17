package com.codybosss.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codybosss.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
