package com.kt.domain.review.model;

import com.kt.domain.customer.model.Customer;
import com.kt.domain.product.model.Product;
import com.kt.global.common.BaseEntity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

public class Review extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "product_id")
	Product product;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	Customer customer;
	
	@NotNull
	private Double rating;
	@NotNull
	private String comment;
}
