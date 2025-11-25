package com.kt.domain.review.model;

import com.kt.domain.customer.model.Customer;
import com.kt.domain.product.model.Product;
import com.kt.global.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Review extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "product_id")
	Product product;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	Customer customer;

	@Column(nullable = false)
	private Double rating;

	private String comment;

	private Review(
		Product product,
		Customer customer,
		Double rating,
		String comment
	) {
		this.product = product;
		this.customer = customer;
		this.rating = rating;
		this.comment = comment;
	}

	public static Review create(
		Product product,
		Customer customer,
		Double rating,
		String comment
	) {
		return new Review(
			product,
			customer,
			rating,
			comment
		);
	}

}
