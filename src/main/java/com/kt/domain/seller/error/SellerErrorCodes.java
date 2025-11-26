package com.kt.domain.seller.error;

import org.springframework.http.HttpStatus;

import com.kt.global.common.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SellerErrorCodes implements ErrorCode {
	SELLER_NOT_FOUND(
		HttpStatus.NOT_FOUND,
		"판매자 정보를 찾지 못했습니다.",
		"SE01"
	),
	;

	private final HttpStatus httpStatus;
	private final String message;
	private final String code;
}