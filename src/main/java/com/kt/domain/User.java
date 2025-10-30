package com.kt.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
// @NoArgsConstructor
@AllArgsConstructor
public class User {
	private Long id;
	private String loginId;
	private String password;
	private String name;
	private String email;
	private String mobile;
	private LocalDateTime birth;
	private Gender gender;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
