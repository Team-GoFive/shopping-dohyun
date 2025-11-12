package com.kt.domain.user;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.kt.common.BaseEntity;
import com.kt.domain.order.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 1. domain과 entity를 분리해야
// 2. 굳이? 같이 쓰지 뭐
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class User extends BaseEntity {
	@OneToMany(mappedBy = "user")
	private final List<Order> orders = new ArrayList<>();
	private String loginId;
	private String password;
	private String name;
	private String email;
	private String mobile;
	private LocalDate birth;
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	private Role role;

	private User(String loginId, String password, String name, String email, String mobile, LocalDate birth,
		Gender gender,
		LocalDateTime createdAt, LocalDateTime updatedAt, Role role) {
		this.loginId = loginId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.birth = birth;
		this.gender = gender;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.role = role;
	}

	public static User normalUser(String loginId, String password, String name, String email, String mobile,
		LocalDate birth, Gender gender,
		LocalDateTime createdAt, LocalDateTime updatedAt) {
		return new User(
			loginId,
			password,
			name,
			email,
			mobile,
			birth,
			gender,
			createdAt,
			updatedAt,
			Role.USER
		);
	}

	public static User adminUser(String loginId, String password, String name, String email, String mobile,
		LocalDate birth, Gender gender,
		LocalDateTime createdAt, LocalDateTime updatedAt) {
		return new User(
			loginId,
			password,
			name,
			email,
			mobile,
			birth,
			gender,
			createdAt,
			updatedAt,
			Role.ADMIN
		);
	}

	public void changePassword(String password) {
		this.password = password;
	}

	public void update(String name, String email, String mobile) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}
}
