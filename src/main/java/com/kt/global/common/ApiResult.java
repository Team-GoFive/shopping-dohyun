package com.kt.global.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiResult<T> {

	private String message;
	private String code;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private T data;

	public static ApiResult<Void> ok() {
		return ApiResult.of(
			"성공",
			"ok",
			null
		);
	}

	public static <T> ApiResult<T> ok(T data) {
		return ApiResult.of(
			"성공",
			"ok",
			data
		);
	}

	public static <T> ApiResult<T> of(
		String code,
		String message,
		T data
	) {
		return new ApiResult<>(
			message,
			code,
			data
		);
	}
}