package com.kt.domain.product.model;

import java.util.ArrayList;
import java.util.List;

import com.kt.domain.review.model.Review;
import com.kt.domain.store.model.Store;
import com.kt.global.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {
	private String productName;
	private Long stock;
	private Long price;
	@Enumerated(EnumType.STRING)
	private ProductStatus productStatus;

	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;

	@OneToMany(mappedBy = "product")
	private List<Review> reviewList = new ArrayList<>();
}
