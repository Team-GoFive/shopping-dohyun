package com.kt.domain.seller.model;

import java.util.ArrayList;
import java.util.List;

import com.kt.domain.store.model.Store;
import com.kt.global.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seller extends BaseEntity {
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String mobile;

	@Column(nullable = false)
	@Email
	private String email;
	@OneToMany(mappedBy = "seller")
	private List<Store> storeList = new ArrayList<>();

	// TODO: 사업자 등록 번호

	private Seller(
		String name,
		String mobile,
		String email,
		List<Store> storeList
	) {
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.storeList = storeList;
	}

	public static Seller create(
		String name,
		String mobile,
		String email,
		List<Store> storeList
	) {
		return new Seller(
			name,
			mobile,
			email,
			storeList
		);
	}
}
