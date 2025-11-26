package com.kt.global.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorResponse {
	private final HttpStatus status;
	private final String code;
	private final String message;

	public static ResponseEntity<ErrorResponse> of(HttpStatus status, String message, String code) {
		return ResponseEntity.status(status).body(
			new ErrorResponse(
				status,
				code,
				message
			)
		);
	}

}
