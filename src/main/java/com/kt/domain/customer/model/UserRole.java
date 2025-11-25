package com.kt.domain.customer.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserRole {
	ADMIN("관리자"),
	CUSTOMER("고객"),
	;

	private final String description;
}
