package com.example.polls.payload;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 *
 *
 * 마지막으로 설문조사를 만들고, 모든 설문조사를 가져오고,
 * 설문조사에서 선택 항목에 투표하고, 사용자 프로필을 가져오고,
 * 사용자가 만든 설문조사를 가져오는 등의 API를 작성해 보겠습니다.
 *
 * 나머지 API는 요청에서 사용자 지정 페이로드를 수락하고 선택한 정보
 * 또는 추가 정보가 포함된 사용자 지정 응답을 클라이언트에 반환합니다.
 */

@Getter @Setter
public class PollRequest {

	@NotBlank
	@Size(max = 140)
	private String question;

	@NotNull
	@Size(min = 2, max = 6)
	@Valid
	private List<ChoiceRequest> choices;

	@NotNull
	@Valid
	private PollLength pollLength;
}
