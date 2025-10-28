package com.kt.dto;

import java.time.LocalDate;


// loginId, password, name, birthday
public record UserCreateRequest(
	String loginId,
	String password,
	String name,
	LocalDate birthday
	) {


}
