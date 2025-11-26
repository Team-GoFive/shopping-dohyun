package com.kt.domain.customer.error;

import org.springframework.http.HttpStatus;

import com.kt.global.common.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CustomerErrorCodes implements ErrorCode {
	CUSTOMER_NOT_FOUND(
		HttpStatus.NOT_FOUND,
		"고객 정보를 찾지 못했습니다.",
		"C01"
	),
	;

	private final HttpStatus httpStatus;
	private final String message;
	private final String code;
}