package com.kt.controller.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kt.common.ApiResult;
import com.kt.dto.auth.LoginRequest;
import com.kt.dto.auth.LoginResponse;
import com.kt.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;
	// 인증 관련 컨트롤러 구현
	// 인증 방식 크게 3가지 존재
	// 1. 세션 기반 인증 -> 서버 쪽에 작은 공간에 사용자 정보를 저장 - 만료 시간
	// -> 서버에서 관리하기 때문에 보안성이 좋다.
	// -> A서버에서 인가를 해줌, 세션에 저장을 하고 있음
	// -> B서버 세션에는 인가된 정보가 있을까?
	// 해결책으로는 세션 클러스터링, 스니키 세션 -> redis 등 redis를 위한 redis 해결책 외부 저장소를 통해 단일 세션, 세션이 A서버에서 생성되었다면 A서버로 트래픽 고정
	// 2. 토근 기반 인증 (JWT) -> 사용자가 토큰을 가지고 있다가 요청할 때마다 같이 줌 -> 서버 입장에서는 신뢰성 x
	// 장점: 서버에서 관리하지 않아 부하가 적음
	// 단점: 매번 검사를 해야함, 분산 환경에 유리
	// 3. OAuth2.0 기반 인증
	// 내 서버에서 하는게 아니라 남한테 맡기는 방식(구글, 카카오, 네이버, 깃허브, 페이스북)
	// 장점 => 사용자 편하려고 만든게 아니라 서버 개발자들 편하려고 사용
	// 왜? => 개인정보를 취급하지 않아도 돼서, 인가 작업 내가 안해도 돼서

	@PostMapping("/login")
	public ApiResult<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
		authService.login(
			request.loginId(),
			request.password()
		);

		return ApiResult.ok();
	}

}
