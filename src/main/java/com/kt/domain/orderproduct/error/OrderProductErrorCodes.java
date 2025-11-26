package com.kt.domain.orderproduct.error;

import org.springframework.http.HttpStatus;

import com.kt.global.common.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderProductErrorCodes implements ErrorCode {
	ORDER_PRODUCT_NOT_FOUND(
		HttpStatus.NOT_FOUND,
		"주문 상품 정보를 찾지 못했습니다.",
		"OP01"
	),
	;

	private final HttpStatus httpStatus;
	private final String message;
	private final String code;
}