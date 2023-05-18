package com.cafyf.code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cafyf.code.entity.Submission;

@Repository
@Transactional
public interface SubmissionRepository extends JpaRepository<Submission,Integer> {
	
          List<Submission> findAllBySessionIdAndSubmissionId(int sessionId,int submissionId);
          
          @Query("SELECT COUNT(e) FROM Submission e WHERE e.submissionId = :submissionId " +
                  "AND e.sessionId = :sessionId AND e.status = 'Accepted'")
          int getCountBySubmissionIdAndSessionIdAndStatusAccepted(@Param("submissionId") int submissionId, @Param("sessionId") int sessionId);
          
          @Query("SELECT COUNT(e) FROM Submission e WHERE e.submissionId = :submissionId " +
                  "AND e.sessionId = :sessionId")
          int getTotalCountBySubmissionIdAndSessionId(@Param("submissionId") int submissionId,@Param("sessionId") int sessionId);
      
      
}
