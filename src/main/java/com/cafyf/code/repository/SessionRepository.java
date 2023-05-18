package com.cafyf.code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cafyf.code.entity.Session;


@Repository
@Transactional
public interface SessionRepository extends JpaRepository<Session,Integer> {
	
	List<Session> findAllBySessionId(int sessionId);
	
	@Modifying
	@Query("UPDATE Session s SET s.totalQuestionsSolved = s.totalQuestionsSolved + 1"
			+ " WHERE s.mode = ?1 AND s.manageId = ?2 AND s.sessionId =?3")
	int updateNoOfQuestionSolved(String mode, int manageId,int sessionId);
	

	@Modifying
	@Query("UPDATE Session s SET s.sessionName = ?1"
			+ " WHERE s.sessionName = ?2 AND s.sessionId =?3")
	int updateSessionName(String newSessionName,String currentSessionName,int sessionId);
	
	@Modifying
	@Query("DELETE FROM Session s WHERE s.manageId = :manageId AND s.sessionId = :sessionId")
	void deleteBySessionNameAndSessionId(@Param("manageId") int manageId, @Param("sessionId") int sessionId);

}
