package com.kt.domain.user.request;

import java.time.LocalDate;

// loginId, password, name, birthday
public record UserCreateRequest(
	String loginId,
	String password,
	String name,
	LocalDate birthday
) {

}
