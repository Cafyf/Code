package com.cafyf.code.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafyf.code.controller.etities.Submissions;
import com.cafyf.code.entity.SessionManagement;
import com.cafyf.code.entity.Submission;
import com.cafyf.code.repository.SubmissionRepository;

@Service
public class SubmissionService {

	@Autowired
	SubmissionRepository submissionRepository;
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
	ProgressService progressService;
	
	@Autowired
	SessionManagementService sessionManagementService;

	
	public Submission saveSubmission(Submissions reqBodyData) {
		
		SessionManagement sessionManagement=sessionManagementService.getSessionDetails(reqBodyData.getSession().getSessionName(), reqBodyData.getSession().getSessionId());
		
		reqBodyData.getSubmission().setSessionId(sessionManagement.getId()); //PK id it the common for every submission and progress
		 // Based on the submission Id only we going to fetch all submission data
		//reqBodyData.getSubmission().setSubmissionId(sessionManagement.getManageId()); 
		
		Submission submission=submissionRepository.save(reqBodyData.getSubmission());
		
		Object obj=	progressService.saveProgress(reqBodyData.getProgress(),submission.getId(),sessionManagement.getId()); // the first getId give the corresponding submission details

		if(!obj.toString().equals("1") && submission.getStatus().equals("Accepted")) {
		reqBodyData.getSession().setManageId(sessionManagement.getId());
		sessionService.updateNoOfQuestionSolved(reqBodyData.getSession());
		}
		
        return submission;
	}
	
	public List<Submission> getSubmissionDetail(int sessionId,int submissionId) {
		
		return submissionRepository.findAllBySessionIdAndSubmissionId(sessionId, submissionId);
	}
	
	public Object getSubmissionCountDetails(int sessionId,int submissionId) {
		Map<String,Integer> countvalue=new HashMap<String,Integer>();
		countvalue.put("acceptedSubmission", submissionRepository.getCountBySubmissionIdAndSessionIdAndStatusAccepted(submissionId, sessionId))	;
		countvalue.put("totalSubmission",submissionRepository.getTotalCountBySubmissionIdAndSessionId(submissionId, sessionId));
		return countvalue;
	}
	
	
	public Optional<Submission> getSingleSubmission(int submissionQuestionId) {
		return submissionRepository.findById(submissionQuestionId);
	}
	
}
