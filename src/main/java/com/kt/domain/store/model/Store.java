package com.kt.domain.store.model;

import java.util.ArrayList;
import java.util.List;

import com.kt.domain.product.model.Product;
import com.kt.domain.seller.model.Seller;
import com.kt.global.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store extends BaseEntity {

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@OneToMany(mappedBy = "store")
	private List<Product> productList = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "seller_id", nullable = false)
	private Seller seller;

	private Store(
		String name,
		String description,
		List<Product> productList,
		Seller seller
	) {
		this.name = name;
		this.description = description;
		this.productList = productList;
		this.seller = seller;
	}

	public static Store create(
		String name,
		String description,
		List<Product> productList,
		Seller seller) {
		return new Store(
			name,
			description,
			productList,
			seller
		);
	}
}
