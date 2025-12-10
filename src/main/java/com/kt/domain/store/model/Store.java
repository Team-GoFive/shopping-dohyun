package com.kt.domain.store.model;

import com.kt.domain.seller.model.Seller;
import com.kt.global.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store extends BaseEntity {

	@Column
	@NotNull
	private String name;

	@Column
	@NotNull
	private String description;

	@ManyToOne
	@JoinColumn(name = "seller_id", nullable = false)
	private Seller seller;

	private Store(
		String name,
		String description,
		Seller seller
	) {
		this.name = name;
		this.description = description;
		this.seller = seller;
	}

	public static Store create(
		String name,
		String description,
		Seller seller) {
		return new Store(
			name,
			description,
			seller
		);
	}
}
