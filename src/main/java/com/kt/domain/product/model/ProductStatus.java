package com.kt.domain.product.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ProductStatus {
	SOLD_OUT("품절"),
	ACTIVE("판매중"),
	INACTIVE("비활성화");

	private final String description;
}
