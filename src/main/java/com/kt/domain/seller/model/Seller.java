package com.kt.domain.seller.model;

import com.kt.global.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seller extends BaseEntity {
	@Column
	@NotNull
	private String name;

	@Column
	@NotNull
	private String mobile;

	@Column
	@NotNull
	@Email
	private String email;

	// TODO: 사업자 등록 번호

	private Seller(
		String name,
		String mobile,
		String email
	) {
		this.name = name;
		this.mobile = mobile;
		this.email = email;
	}

	public static Seller create(
		String name,
		String mobile,
		String email
	) {
		return new Seller(
			name,
			mobile,
			email
		);
	}
}
