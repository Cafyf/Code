package com.cafyf.code.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cafyf.code.entity.SessionManagement;

@Repository
@Transactional
public interface SessionManagementRepository extends JpaRepository<SessionManagement,Integer> {

	
        SessionManagement findBySessionNameAndManageId(String sessionName, int manageId);
    
	    @Modifying
	    @Query("UPDATE SessionManagement s SET s.sessionName = ?1 WHERE s.sessionName = ?2 AND s.manageId = ?3")
	    int updateSessionNameBySessionNameAndManageId(String newSessionName, String sessionName, int manageId);
}
