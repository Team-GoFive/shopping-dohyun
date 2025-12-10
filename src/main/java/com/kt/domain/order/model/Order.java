package com.kt.domain.order.model;

import com.kt.domain.customer.model.Customer;
import com.kt.global.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Order extends BaseEntity {

	@Embedded
	private AddressVO addressVO;

	@Column(nullable = false)
	private Long totalPrice;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	private Order(
		AddressVO addressVO,
		Long totalPrice,
		Customer customer
	) {
		this.addressVO = addressVO;
		this.totalPrice = totalPrice;
		this.customer = customer;
	}

	public static Order create(
		AddressVO addressVO,
		Long totalPrice,
		Customer customer
	) {
		return new Order(
			addressVO,
			totalPrice,
			customer
		);
	}
}
