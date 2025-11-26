package com.kt.global.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponses {
	public static <T> ResponseEntity<ApiResult<T>> ok(T data) {
		return ResponseEntity.ok(ApiResult.ok(data));
	}

	public static <T> ResponseEntity<ApiResult<T>> created(T data) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ApiResult.ok(data));
	}

	public static <T> ResponseEntity<ApiResult<T>> noContent(T data) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ApiResult.ok(data));
	}

}
