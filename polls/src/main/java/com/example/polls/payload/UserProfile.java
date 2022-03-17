package com.example.polls.payload;

import java.time.Instant;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserProfile {

	private Long id;
	private String username;
	private String name;
	private LocalDateTime joinedAt;
	private Long pollCount;
	private Long voteCount;

	public UserProfile(Long id, String username, String name,
		LocalDateTime joinedAt, Long pollCount, Long voteCount) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.joinedAt = joinedAt;
		this.pollCount = pollCount;
		this.voteCount = voteCount;
	}
}
