package com.kt.domain.seller.model;

import java.util.ArrayList;
import java.util.List;

import com.kt.domain.store.model.Store;
import com.kt.global.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seller extends BaseEntity {
	@NotNull
	private String name;
	@NotNull
	private String mobile;
	@NotNull
	@Email
	private String email;
	@OneToMany(mappedBy = "seller")
	private List<Store> storeList = new ArrayList<>();

	// TODO: 사업자 등록 번호
}
