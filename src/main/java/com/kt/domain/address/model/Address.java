package com.kt.domain.address.model;

import com.kt.domain.customer.model.Customer;
import com.kt.global.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Address extends BaseEntity {
	@NotNull
	private String address;
	@NotNull
	private String detailAddress;
	@NotNull
	private String mobile;
	@NotNull
	private String receiverName;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
}
