package com.kt.global.common;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@RestControllerAdvice
public class ApiAdvice {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> customException(CustomException e) {
		return ErrorResponse.of(
			e.error().getHttpStatus(),
			e.error().getMessage(),
			e.error().getCode()
		);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> internalServerError(Exception e) {
		return ErrorResponse.of(
			HttpStatus.INTERNAL_SERVER_ERROR,
			"서버 에러입니다. 백엔드팀에 문의해주세요",
			"E01"
		);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		e.printStackTrace();
		var details = Arrays.toString(e.getDetailMessageArguments());
		var message = details.split(
			",",
			2
		)[1].replace(
			"]",
			""
		).trim();

		return ErrorResponse.of(
			HttpStatus.BAD_REQUEST,
			message,
			"A01"
		);
	}

}
