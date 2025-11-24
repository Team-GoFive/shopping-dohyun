package com.kt.domain.order.model;

import com.kt.domain.customer.model.Customer;
import com.kt.global.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Order extends BaseEntity {

	private Long totalPrice;
	private

	@ManyToOne
	Customer user;

}
