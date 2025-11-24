package com.kt.domain.user.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.kt.domain.user.model.User;
import com.kt.domain.user.repository.UserRepository;
import com.kt.domain.user.request.MemberCreateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public void create(MemberCreateRequest request) {
		User member = User.memberUser(
			request.loginId(),
			UUID.randomUUID(),
			request.password(),
			request.name(),
			request.birthday(),
			request.gender()
		);
		userRepository.save(member);
	}
}
