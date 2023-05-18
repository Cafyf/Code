package com.cafyf.code.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cafyf.code.entity.Progress;

@Repository
@Transactional
public interface ProgressRepository extends JpaRepository<Progress,Integer> {
	
	List<Progress> findAllBySessionIdAndProgressId(int sessionId, int progressId);

	Progress findByModeAndProgressIdAndQuestionAndTopicAndSessionId(String mode,int progressId, String question,String topic,int sessionId);

	@Modifying
	@Transactional
	@Query("UPDATE Progress p SET p.submissionQuestionId = ?1, p.status = ?2 WHERE p.mode = ?3  AND p.question = ?4 AND p.progressId = ?5 AND p.topic = ?6 AND p.sessionId =?7")
	int updateSubmissionQuestionIdAndStatus(int submissionQuestionId, String status, String mode, String question, int progressId, String topic,int sessionId);

	@Query("SELECT COUNT(CASE WHEN e.status = 'Accepted' THEN 1 END) AS acceptedCount, " +
	        "COUNT(e) AS totalCount " +
	        "FROM Progress e " +
	        "WHERE e.sessionId = :sessionId AND e.progressId = :progressId " +
	        "AND (e.status = 'Accepted' OR e.status = 'Error')")
	Map<String, Integer> getCountsBySessionProgressAndStatus(@Param("sessionId") int sessionId,@Param("progressId") int progressId);
	
}
