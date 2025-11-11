package com.kt.common;

import org.springframework.data.domain.PageRequest;

public record Paging(
	int page,
	int size
) {
	public PageRequest toPagable() {
		return PageRequest.of(page, size);
	}
}
