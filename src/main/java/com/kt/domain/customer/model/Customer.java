package com.kt.domain.customer.model;

import java.time.LocalDate;
import java.util.UUID;

import com.kt.global.common.BaseEntity;
import com.kt.global.constants.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer extends BaseEntity {
	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private UUID uuid;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private LocalDate birthday;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private UserRole role;

	private Customer(
		String email,
		UUID uuid,
		String password,
		String name,
		LocalDate birthday,
		Gender gender,
		UserRole role
	) {
		this.email = email;
		this.uuid = uuid;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.role = role;
	}

	public static Customer memberUser(
		String email,
		UUID uuid,
		String password,
		String name,
		LocalDate birthday,
		Gender gender
	) {
		return new Customer(
			email,
			uuid,
			password,
			name,
			birthday,
			gender,
			UserRole.CUSTOMER
		);
	}

	public static Customer adminUser(
		String email,
		UUID uuid,
		String password,
		String name,
		LocalDate birthday,
		Gender gender
	) {
		return new Customer(
			email,
			uuid,
			password,
			name,
			birthday,
			gender,
			UserRole.ADMIN
		);
	}
}
