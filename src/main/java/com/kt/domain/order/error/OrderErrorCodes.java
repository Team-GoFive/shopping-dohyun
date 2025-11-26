package com.kt.domain.order.error;

import org.springframework.http.HttpStatus;

import com.kt.global.common.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderErrorCodes implements ErrorCode {
	ORDER_NOT_FOUND(
		HttpStatus.NOT_FOUND,
		"주문 정보를 찾지 못했습니다.",
		"O01"
	),
	;

	private final HttpStatus httpStatus;
	private final String message;
	private final String code;
}