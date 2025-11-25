package com.kt.domain.address.model;

import com.kt.domain.customer.model.Customer;
import com.kt.global.common.BaseEntity;

import jakarta.persistence.Column;
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
	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String detailAddress;

	@Column(nullable = false)
	private String mobile;

	@Column(nullable = false)
	private String receiverName;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	private Address(
		String address,
		String detailAddress,
		String mobile,
		String receiverName
	) {
		this.address = address;
		this.detailAddress = detailAddress;
		this.mobile = mobile;
		this.receiverName = receiverName;
	}

	public static Address create(
		String address,
		String detailAddress,
		String mobile,
		String receiverName
	) {
		return new Address(
			address,
			detailAddress,
			mobile,
			receiverName
		);
	}
}
