package com.example.polls.payload;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 * API를 정의하기 전에 API가 사용할 요청 및 응답 페이로드를 정의해야 합니다.
 * 먼저 이러한 페이로드를 정의해 보겠습니다.
 */

@Getter @Setter
public class LoginRequest {

	@NotBlank
	private String usernameOrEmail;

	@NotBlank
	private String password;
}

