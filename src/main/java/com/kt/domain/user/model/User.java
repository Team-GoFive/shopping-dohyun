package com.kt.domain.user.model;

import java.time.LocalDate;
import java.util.UUID;

import com.kt.global.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
	private String loginId;
	private UUID uuid;
	private String password;
	private String name;
	private LocalDate birthday;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Enumerated(EnumType.STRING)
	private UserRole role;

	private User(
		String loginId,
		UUID uuid,
		String password,
		String name,
		LocalDate birthday,
		Gender gender,
		UserRole role
	) {
		this.loginId = loginId;
		this.uuid = uuid;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.role = role;
	}

	public static User memberUser(
		String loginId,
		UUID uuid,
		String password,
		String name,
		LocalDate birthday,
		Gender gender
	) {
		return new User(
			loginId,
			uuid,
			password,
			name,
			birthday,
			gender,
			UserRole.MEMBER
		);
	}

	public static User adminUser(
		String loginId,
		UUID uuid,
		String password,
		String name,
		LocalDate birthday,
		Gender gender
	) {
		return new User(
			loginId,
			uuid,
			password,
			name,
			birthday,
			gender,
			UserRole.ADMIN
		);
	}
}
