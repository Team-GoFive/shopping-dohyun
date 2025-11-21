package com.kt.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtService {
	private final JwtProperties jwtProperties;

	// Key는 저희가 설정한 어떤 임의의 값을 통해서 Key를 생성함
	public String issue(Long id, Date expiration) {
		// id 값은 jwt의 식별자 같은 개념 -> User의 id값
		// claims -> jwt안에 들어갈 정보를 Map 형태로 넣는데 id, 1

		// 2가지의 토큰으로 웹에서는 제어
		// access token -> 짧은 유효기간: 5분 -> 리프레시 토큰으로 새로운 액세스 토큰 발급
		// refresh token -> 긴 유효기간: 12시간 -> 만료되면 로그인 다시 해야됨
		return Jwts.builder()
			.subject("kt-cloud-shopping")
			.issuer("roy")
			.issuedAt(new Date())
			.id(id.toString())
			.expiration(expiration)
			// Key를 구현해서 넣어주어야 할 것 같음
			.signWith(jwtProperties.getSecret())
			.compact();

	}

	public Date getAccessExpiration() {
		return jwtProperties.getAccessTokenExpiration();
	}

	public Date getRefreshExpiration() {
		return jwtProperties.getRefreshTokenExpiration();
	}

	public boolean validate(String token) {
		return Jwts.parser()
			.verifyWith(jwtProperties.getSecret())
			.build()
			.isSigned(token);
	}

	public Long parseId(String token) {
		String id = Jwts.parser()
			.verifyWith(jwtProperties.getSecret())
			.build()
			.parseSignedClaims(token)
			.getPayload()
			.getId();

		return Long.valueOf(id);
	}
}
