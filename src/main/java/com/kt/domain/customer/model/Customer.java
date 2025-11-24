package com.kt.domain.customer.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.kt.domain.address.model.Address;
import com.kt.global.common.BaseEntity;
import com.kt.global.constants.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer extends BaseEntity {
	private String loginId;
	private UUID uuid;
	private String password;
	private String name;
	private LocalDate birthday;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Enumerated(EnumType.STRING)
	private UserRole role;
	@OneToMany(mappedBy = "address")
	private List<Address> addressList = new ArrayList<>();

	private Customer(
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

	public static Customer memberUser(
		String loginId,
		UUID uuid,
		String password,
		String name,
		LocalDate birthday,
		Gender gender
	) {
		return new Customer(
			loginId,
			uuid,
			password,
			name,
			birthday,
			gender,
			UserRole.Customer
		);
	}

	public static Customer adminUser(
		String loginId,
		UUID uuid,
		String password,
		String name,
		LocalDate birthday,
		Gender gender
	) {
		return new Customer(
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
