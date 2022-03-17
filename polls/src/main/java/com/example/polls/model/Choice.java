package com.example.polls.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "choices")
@Getter @Setter
public class Choice {

	@Id @GeneratedValue
	private Long id;

	@NotBlank
	@Size(max = 40)
	private String text;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "poll_id", nullable = false)
	private Poll poll;

	public Choice() {

	}

	public Choice(String text) {
		this.text = text;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Choice choice = (Choice) o;
		return Objects.equals(id, choice.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
