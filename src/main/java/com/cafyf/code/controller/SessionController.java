package com.cafyf.code.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafyf.code.entity.Session;
import com.cafyf.code.entity.SessionGroup;
import com.cafyf.code.service.ProgressService;
import com.cafyf.code.service.SessionService;
import com.cafyf.code.service.SubmissionService;

@CrossOrigin("http://localhost:8081")
@RestController
public class SessionController {

	@Autowired
	SessionService sessionService;
	
	@Autowired
	ProgressService progressService;
	
	@Autowired
	SubmissionService submissionService;
	
	@GetMapping("/sessionDetails")
	public List<SessionGroup> getSessiondetails(@RequestParam int sessionId) {
		return sessionService.getSessionData(sessionId);
	}
	
	@PostMapping("/createSession")
	public int createSession(@RequestParam String sessionName, @RequestParam int loginId) {
		return  sessionService.setUp(sessionName, loginId);
	}
	
	@PostMapping("/renameSession")
	public Object renameSession(@RequestParam String newSessionName, @RequestParam String currentSessionName,@RequestParam int loginId) {
		return sessionService.renameSession(newSessionName, currentSessionName, loginId);
	}
	
	@GetMapping("/sessionActive")
	public Object getSessionActiveDetails(@RequestParam int loginId) {
		Map<String,Object> details=new HashMap<String,Object>();
	    List<SessionGroup> sessionList=sessionService.getSessionData(loginId);
		details.put("sessionDetails",sessionList);
		for(SessionGroup session:sessionList) {                                                          // manageId is user login sessionId
		details.put("submissionManageId"+session.getManageId(),submissionService.getSubmissionCountDetails(session.getManageId(), loginId));
		details.put("progressManageId"+session.getManageId(), progressService.getNoOfQuestions(session.getManageId(), loginId));
		}
	return details ;
	}
}
