package com.cafyf.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafyf.code.entity.Progress;
import com.cafyf.code.repository.ProgressRepository;

@Service
public class ProgressService {
	
	@Autowired
	ProgressRepository progressReposiotry;

	public Object saveProgress(Progress reqData,int submissionQuestionId,int sessionManagementId) {
		reqData.setSubmissionQuestionId(submissionQuestionId);
		reqData.setSessionId(sessionManagementId);
		
		if(findExistingOne(reqData)==1) {
			//the submissionQuestion id is primary key of submission...
	return progressReposiotry.updateSubmissionQuestionIdAndStatus(submissionQuestionId,reqData.getStatus(),reqData.getMode()
				,reqData.getQuestion(),reqData.getProgressId(),reqData.getTopic(),reqData.getSessionId());
		}
		
		return progressReposiotry.save(reqData);
	}
	
	public int findExistingOne(Progress data) {
		if(progressReposiotry.findByModeAndProgressIdAndQuestionAndTopicAndSessionId(data.getMode(),
				data.getProgressId(),data.getQuestion(),data.getTopic(),data.getSessionId())!=null)
		{
			return 1;
		}
         return 0;
	}
	
	public List<Progress> getProgressDetails(int sessionId, int progressId) {
		return progressReposiotry.findAllBySessionIdAndProgressId(sessionId, progressId);
	}
	
	public Object getNoOfQuestions(int sessionId,int progressId) {
		
		return progressReposiotry.getCountsBySessionProgressAndStatus(sessionId, progressId);
		
	}
	
}
