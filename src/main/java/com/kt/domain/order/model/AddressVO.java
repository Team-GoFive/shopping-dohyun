package com.kt.domain.order.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class AddressVO {
	private String address;
	private String receiverName;
	private String receiverPhone;
}
