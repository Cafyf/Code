package com.cafyf.code.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafyf.code.entity.Session;
import com.cafyf.code.entity.SessionGroup;
import com.cafyf.code.entity.SessionManagement;
import com.cafyf.code.repository.SessionManagementRepository;
import com.cafyf.code.repository.SessionRepository;

import lombok.Getter;
import lombok.Setter;

@Service
public class SessionService {

	@Autowired
	SessionRepository sessionRepository;
	
	@Autowired
	SessionManagementRepository sessionManagement;
	
	public int setUp(String sessionName,int sessionId) {
		
		SessionManagement s = new SessionManagement() ;
		s.setSessionName(sessionName);
		s.setManageId(sessionId);
		
		int manageId=sessionManagement.save(s).getId();
		
		String[] modes = {"easy", "medium", "hard"};

		for (String mode : modes) {
		    Session session = new Session();
		    session.setSessionId(sessionId); // this userId used to fetch the section details
		    session.setSessionName(sessionName);
		    session.setTotalQuestionsSolved("0");
		    session.setMode(mode);
		    session.setManageId(manageId);
		    sessionRepository.save(session);
		}
		
		return manageId;
	}
	
	public List<SessionGroup> getSessionData(int SessionId) { // sessionId means LoginId
	    return organizeSession(sessionRepository.findAllBySessionId(SessionId));
	}
	
	public Object updateNoOfQuestionSolved(Session reqData) {
		return sessionRepository.updateNoOfQuestionSolved(reqData.getMode(),reqData.getManageId(),reqData.getSessionId());
	}
	
	public Object renameSession(String newSessionName,String currentSessionName,int sessionId) {
		sessionManagement.updateSessionNameBySessionNameAndManageId(newSessionName, currentSessionName, sessionId);
		return sessionRepository.updateSessionName(newSessionName,currentSessionName,sessionId);
	}
	
	public String deleteSession(int manageId,int sessionId) {
		sessionRepository.deleteBySessionNameAndSessionId(manageId, sessionId);
		return "success";
	}
	
	public List<SessionGroup> organizeSession(List<Session> sessionData) {
		   // Replace 1 with the desired sessionId

        Map<Integer, SessionGroup> groupedData = new HashMap<>();

        for (Session session : sessionData) {
            int manageId = session.getManageId();
            String mode = session.getMode();
            int totalQuestionsSolved = Integer.parseInt(session.getTotalQuestionsSolved());

            SessionGroup sessionGroup = groupedData.getOrDefault(manageId, new SessionGroup());
            sessionGroup.setSessionId(session.getSessionId());
            sessionGroup.setSessionName(session.getSessionName());
            sessionGroup.setManageId(manageId);

            Map<String, Integer> modes = sessionGroup.getModes();
            modes.putIfAbsent(mode, 0);
            modes.put(mode, modes.get(mode) + totalQuestionsSolved);

            groupedData.put(manageId, sessionGroup);
        }

        List<SessionGroup> result = new ArrayList<>(groupedData.values());
             System.out.println(result);
              return result;
	}
	
	
	
}
