package com.kt.domain.user.request;

import java.time.LocalDate;

import com.kt.domain.user.model.Gender;

import jakarta.validation.constraints.NotNull;

public record AdminCreateRequest(
	@NotNull
	String loginId,
	@NotNull
	String password,
	@NotNull
	String name,
	@NotNull
	LocalDate birthday,
	@NotNull
	Gender gender
) {

}
