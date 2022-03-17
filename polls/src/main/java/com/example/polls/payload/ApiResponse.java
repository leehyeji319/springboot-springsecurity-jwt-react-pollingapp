package com.example.polls.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//  Jwt인증 응답

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ApiResponse {

	private Boolean success;
	private String message;
}
