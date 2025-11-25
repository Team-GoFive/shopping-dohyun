package com.kt.domain.order.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressVO {
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String receiverName;
	@Column(nullable = false)
	private String receiverPhone;

	private AddressVO(
		String address,
		String receiverName,
		String receiverPhone
	) {
		this.address = address;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
	}

	public static AddressVO create(
		String address,
		String receiverName,
		String receiverPhone
	) {
		return new AddressVO(
			address,
			receiverName,
			receiverPhone
		);
	}
}

