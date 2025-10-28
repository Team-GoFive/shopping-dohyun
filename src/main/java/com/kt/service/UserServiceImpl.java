package com.kt.service;

import org.springframework.stereotype.Service;

import com.kt.domain.User;
import com.kt.dto.UserCreateRequest;
import com.kt.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public void create(UserCreateRequest request) {
		userRepository.save(new User(
			request.loginId(),
			request.password(),
			request.name(),
			request.birthday()
		));
	}

	@Override
	public User findByLoginId(String loginId) {
		return userRepository.read(loginId);
	}

	@Override
	public void delete(String loginId) {
		userRepository.delete(loginId);
	}

}
