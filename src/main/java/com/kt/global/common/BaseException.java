package com.kt.global.common;

import org.springframework.core.NestedRuntimeException;

import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
public class BaseException extends NestedRuntimeException {
	@Accessors(fluent = true)
	private final ErrorCode error;

	public BaseException(ErrorCode error) {
		super(error.getMessage());
		this.error = error;
	}
}
