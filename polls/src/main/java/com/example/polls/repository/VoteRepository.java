package com.example.polls.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.polls.model.ChoiceVoteCount;
import com.example.polls.model.Vote;

/**
 *
 * 일부 쿼리에서 JPQL 생성자 표현식 을 사용하여
 * 사용자 정의 클래스 형식으로 쿼리 결과를 반환하고 있습니다 ChoiceVoteCount.
 */

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
	@Query("SELECT NEW com.example.polls.model.ChoiceVoteCount(v.choice.id, count(v.id)) FROM Vote v WHERE v.poll.id in :pollIds GROUP BY v.choice.id")
	List<ChoiceVoteCount> countByPollIdInGroupByChoiceId(@Param("pollIds") List<Long> pollIds);

	@Query("SELECT NEW com.example.polls.model.ChoiceVoteCount(v.choice.id, count(v.id)) FROM Vote v WHERE v.poll.id = :pollId GROUP BY v.choice.id")
	List<ChoiceVoteCount> countByPollIdGroupByChoiceId(@Param("pollId") Long pollId);

	@Query("SELECT v FROM Vote v where v.user.id = :userId and v.poll.id in :pollIds")
	List<Vote> findByUserIdAndPollIdIn(@Param("userId") Long userId, @Param("pollIds") List<Long> pollIds);

	@Query("SELECT v FROM Vote v where v.user.id = :userId and v.poll.id = :pollId")
	Vote findByUserIdAndPollId(@Param("userId") Long userId, @Param("pollId") Long pollId);

	@Query("SELECT COUNT(v.id) from Vote v where v.user.id = :userId")
	long countByUserId(@Param("userId") Long userId);

	@Query("SELECT v.poll.id FROM Vote v WHERE v.user.id = :userId")
	Page<Long> findVotedPollIdsByUserId(@Param("userId") Long userId, Pageable pageable);
}
