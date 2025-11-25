package com.kt.global.constants;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Gender {
	MALE("남자"),
	FEMALE("여자"),
	;

	private final String description;
}
