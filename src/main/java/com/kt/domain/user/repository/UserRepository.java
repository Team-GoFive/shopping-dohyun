package com.kt.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt.domain.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
