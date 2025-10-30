package com.kt.service;

import org.springframework.stereotype.Service;

import com.kt.domain.User;
import com.kt.dto.UserCreateRequest;
import com.kt.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public void create(UserCreateRequest request) {
		System.out.println(request.toString());
		var newUser = new User(
			request.id(),
			request.loginId(),
			request.password(),
			request.name(),
			request.email(),
			request.birth(),
			request.gender(),
			request.createdAt(),
			request.updatedAt()
		);

		// repository로 넘김
		userRepository.save(newUser);

	}

	// TODO: 아이디 중복 검사 만들기
}
