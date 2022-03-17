package com.example.polls.model.audit;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * 사용자 감사를 수행하기 위해 첫 번째 부분에서 정의한 모델을
 * UserDateAudit확장 하는 감사 모델을 정의해 보겠습니다.
 * DateAudit
 * createdBy및 updatedBy필드 가 포함 됩니다.
 */

@MappedSuperclass
@JsonIgnoreProperties(
	value = {"createdBy", "updatedBy"},
	allowGetters = true
)
@Getter @Setter
public abstract class UserDateAudit extends DateAudit {
	@CreatedBy
	@Column(updatable = false)
	private Long createdBy;

	@LastModifiedDate
	private Long updatedBy;


}
