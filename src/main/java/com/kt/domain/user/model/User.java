package com.kt.domain.user.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
// @NoArgsConstructor
@AllArgsConstructor
public class User {
	private String loginId;
	private String password;
	private String name;
	private LocalDate birthday;
}
