package com.kt.service;

import org.springframework.data.util.Pair;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kt.common.CustomException;
import com.kt.common.ErrorCode;
import com.kt.common.Preconditions;
import com.kt.domain.user.User;
import com.kt.repository.user.UserRepository;
import com.kt.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;

	public Pair<String, String> login(String loginId, String password) {
		//
		User user = userRepository.findByLoginId(loginId)
			.orElseThrow(() -> new CustomException(ErrorCode.FAIL_LOGIN));
		// Bcrypt로 암호화된 정보 -> 단방향 해시 암호화 -> 기본 5번 해시 알고리즘
		// 요청 들어온 password 또 해시 알고리즘 돌려서 맞는지 비교

		Preconditions.validate(
			passwordEncoder.matches(
				password,
				user.getPassword()
			),
			ErrorCode.FAIL_LOGIN
		);

		// 로그인 성공 처리 -> JWT 토큰 발금
		// 헤더에 넣어서 줄 수도 있고,
		// 바디에 넣어서 줄 수도 있고, -> 보통 실행
		// 쿠키에 넣어서 줄 수도 있고

		String accessToken = jwtService.issue(
			user.getId(),
			jwtService.getAccessExpiration()
		);

		String refreshToken = jwtService.issue(
			user.getId(),
			jwtService.getRefreshExpiration()
		);

		return Pair.of(
			accessToken,
			refreshToken
		);
	}
}
