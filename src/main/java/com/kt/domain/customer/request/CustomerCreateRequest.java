package com.kt.domain.customer.request;

import java.time.LocalDate;

import com.kt.domain.customer.model.Gender;

import jakarta.validation.constraints.NotNull;

public record CustomerCreateRequest(
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
