package com.kt.domain.address.model;

import com.kt.domain.customer.model.Customer;
import com.kt.global.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Address extends BaseEntity {
	private String address;
	private String detailAddress;
	private String mobile;
	private String receiverName;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
}
