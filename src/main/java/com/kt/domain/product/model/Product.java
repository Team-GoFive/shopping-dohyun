package com.kt.domain.product.model;

import com.kt.domain.store.model.Store;
import com.kt.global.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Long stock;

	@Column(nullable = false)
	private Long price;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ProductStatus productStatus;

	@ManyToOne
	@JoinColumn(name = "store_id", nullable = false)
	private Store store;

	private Product(
		String name,
		Long stock,
		Long price,
		ProductStatus productStatus,
		Store store
	) {
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.productStatus = productStatus;
		this.store = store;
	}

	public static Product create(
		String name,
		Long stock,
		Long price,
		ProductStatus productStatus,
		Store store
	) {
		return new Product(
			name,
			stock,
			price,
			productStatus,
			store
		);
	}
}
