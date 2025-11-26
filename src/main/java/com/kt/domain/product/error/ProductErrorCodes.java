package com.kt.domain.product.error;

import org.springframework.http.HttpStatus;

import com.kt.global.common.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductErrorCodes implements ErrorCode {
	PRODUCT_NOT_FOUND(
		HttpStatus.NOT_FOUND,
		"고객 정보를 찾지 못했습니다.",
		"A01"
	),
	;

	private final HttpStatus httpStatus;
	private final String message;
	private final String code;
}