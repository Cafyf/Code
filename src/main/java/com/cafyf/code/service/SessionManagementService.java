package com.cafyf.code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafyf.code.entity.SessionManagement;
import com.cafyf.code.repository.SessionManagementRepository;

@Service
public class SessionManagementService {
	
	@Autowired
	SessionManagementRepository sessionManagement;

	public SessionManagement getSessionDetails(String sessionName,int manageId) {
		
		return sessionManagement.findBySessionNameAndManageId(sessionName, manageId); //manageId means loginId
		
	}
}
