package com.kt.service;
import com.kt.domain.User;
import com.kt.dto.UserCreateRequest;

public interface UserService {
	void create(UserCreateRequest request);
	User findByLoginId(String loginId);
}
