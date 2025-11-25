package com.kt.global.common;

import org.springframework.http.HttpStatus;

import com.kt.domain.address.error.AddressErrorCodes;
import com.kt.domain.customer.error.CustomerErrorCodes;
import com.kt.domain.order.error.OrderErrorCodes;
import com.kt.domain.orderproduct.error.OrderProductErrorCodes;
import com.kt.domain.product.error.ProductErrorCodes;
import com.kt.domain.review.error.ReviewErrorCodes;
import com.kt.domain.seller.error.SellerErrorCodes;
import com.kt.domain.store.error.StoreErrorCodes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
	// Address
	ADDRESS_NOT_FOUND(
		HttpStatus.BAD_REQUEST,
		"주소 정보를 찾지 못했습니다.",
		AddressErrorCodes.NOT_FOUND
	),
	// Auth

	// Order
	ORDER_NOT_FOUND(
		HttpStatus.BAD_REQUEST,
		"주문 정보를 찾지 못했습니다.",
		OrderErrorCodes.NOT_FOUND
	),
	// OrderProduct
	ORDER_PRODUCT_NOT_FOUND(
		HttpStatus.BAD_REQUEST,
		"주문 상품 정보를 찾지 못했습니다.",
		OrderProductErrorCodes.NOT_FOUND
	),
	// Customer
	CUSTOMER_NOT_FOUND(
		HttpStatus.BAD_REQUEST,
		"고객 정보를 찾지 못했습니다.",
		CustomerErrorCodes.NOT_FOUND
	),
	// Payment

	// Product
	PRODUCT_NOT_FOUND(
		HttpStatus.BAD_REQUEST,
		"상품 정보를 찾지 못했습니다.",
		ProductErrorCodes.NOT_FOUND
	),
	// Review
	REVIEW_NOT_FOUND(
		HttpStatus.BAD_REQUEST,
		"리뷰 정보를 찾지 못했습니다.",
		ReviewErrorCodes.NOT_FOUND
	),
	// Seller
	SELLER_NOT_FOUND(
		HttpStatus.BAD_REQUEST,
		"판매자 정보를 찾지 못했습니다.",
		SellerErrorCodes.NOT_FOUND
	),

	// Store
	STORE_NOT_FOUND(
		HttpStatus.BAD_REQUEST,
		"가게 정보를 찾지 못했습니다.",
		StoreErrorCodes.NOT_FOUND
	),
	;

	private final HttpStatus httpStatus;
	private final String message;
	private final String code;
}
