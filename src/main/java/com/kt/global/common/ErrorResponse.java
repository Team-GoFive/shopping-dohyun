package com.kt.global.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

//TODO: refactor
public class ErrorResponse {
	private HttpStatus status;
	private String message;

	public static ResponseEntity<ErrorData> error(HttpStatus status, String message, String code) {
		return ResponseEntity.status(status).body(ErrorData.of(
			status.series().name(),
			message,
			code
		));
	}

	@Getter
	@AllArgsConstructor
	public static class ErrorData {
		private String status;
		private String code;
		private String message;

		public static ErrorData of(String status, String message, String code) {
			return new ErrorData(
				status,
				code,
				message
			);
		}
	}
}
