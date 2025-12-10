package com.kt.global.common;

import lombok.Getter;

@Getter
public class CustomException extends BaseException {

	public CustomException(ErrorCode error) {
		super(error);
	}

}
