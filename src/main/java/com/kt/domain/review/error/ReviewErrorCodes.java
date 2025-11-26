package com.kt.domain.review.error;

import org.springframework.http.HttpStatus;

import com.kt.global.common.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReviewErrorCodes implements ErrorCode {
	REVIEW_NOT_FOUND(
		HttpStatus.NOT_FOUND,
		"리뷰 정보를 찾지 못했습니다.",
		"R01"
	),
	;

	private final HttpStatus httpStatus;
	private final String message;
	private final String code;
}