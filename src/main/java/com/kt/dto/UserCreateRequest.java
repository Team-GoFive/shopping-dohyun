package com.kt.dto;

import java.time.LocalDateTime;

import com.kt.domain.Gender;

// loginId, password, name, birthday
public record UserCreateRequest(
	Long id,
	String loginId,
	String password,
	String name,
	String email,
	LocalDateTime birth,
	Gender gender,
	LocalDateTime createdAt,
	LocalDateTime updatedAt
) {

}
