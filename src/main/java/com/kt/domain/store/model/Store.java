package com.kt.domain.store.model;

import java.util.ArrayList;
import java.util.List;

import com.kt.domain.product.model.Product;
import com.kt.domain.seller.model.Seller;
import com.kt.global.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store extends BaseEntity {
	@NotNull
	private String name;
	@NotNull
	private String description;
	@OneToMany(mappedBy = "store")
	private List<Product> productList = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private Seller seller;
}
