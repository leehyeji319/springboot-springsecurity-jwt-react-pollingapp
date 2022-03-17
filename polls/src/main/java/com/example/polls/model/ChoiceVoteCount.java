package com.example.polls.model;

import lombok.Getter;
import lombok.Setter;

/**
 * ChoiceVoteCount클래스는 VoteRepository쿼리에서
 * 사용자 지정 결과를 반환 하는 데 사용됩니다. 전체 ChoiceVoteCount수업 은 다음과 같습니다.
 */

@Getter @Setter
public class ChoiceVoteCount {

	private Long choiceId;
	private Long voteCount;

	public ChoiceVoteCount(Long choiceId, Long voteCount) {
		this.choiceId = choiceId;
		this.voteCount = voteCount;
	}
}
