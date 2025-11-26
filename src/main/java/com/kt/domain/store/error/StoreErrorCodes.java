package com.kt.domain.store.error;

import org.springframework.http.HttpStatus;

import com.kt.global.common.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StoreErrorCodes implements ErrorCode {
	STORE_NOT_FOUND(
		HttpStatus.NOT_FOUND,
		"가게 정보를 찾지 못했습니다.",
		"ST01"
	),
	;

	private final HttpStatus httpStatus;
	private final String message;
	private final String code;
}