package com.kt.domain.user.service;

import org.springframework.stereotype.Service;

import com.kt.domain.user.model.User;
import com.kt.domain.user.repository.UserRepository;
import com.kt.domain.user.request.UserCreateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public void create(UserCreateRequest request) {
		System.out.println(request.toString());
		var newUser = new User(
			request.loginId(),
			request.password(),
			request.name(),
			request.birthday()
		);

		// repository로 넘김
		userRepository.save(newUser);

	}
}
