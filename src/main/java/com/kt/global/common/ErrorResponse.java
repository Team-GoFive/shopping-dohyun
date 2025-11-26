package com.kt.global.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public record ErrorResponse(String message, String code) {
	public static ResponseEntity<ErrorResponse> of(HttpStatus status, String message, String code) {
		return ResponseEntity.status(status).body(
			new ErrorResponse(
				message,
				code
			)
		);
	}

}
