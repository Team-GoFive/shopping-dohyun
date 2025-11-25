package com.kt.domain.orderproduct.model;

import com.kt.domain.order.model.Order;
import com.kt.domain.product.model.Product;
import com.kt.global.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderProduct extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	private OrderProduct(
		Order order,
		Product product
	) {
		this.order = order;
		this.product = product;
	}

	public static OrderProduct create(
		Order order,
		Product product
	) {
		return new OrderProduct(
			order,
			product
		);
	}
}
