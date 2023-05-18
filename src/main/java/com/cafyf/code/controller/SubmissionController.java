package com.cafyf.code.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafyf.code.controller.etities.Submissions;
import com.cafyf.code.entity.Submission;
import com.cafyf.code.service.SubmissionService;

@CrossOrigin("http://localhost:8081")
@RestController
public class SubmissionController {

	@Autowired
	SubmissionService submissionService;
	
	@PostMapping("/submit")
	public Submission submit(@RequestBody Submissions reqBody) {
		return submissionService.saveSubmission(reqBody);
	}
	
	@GetMapping("/submissionDetails")
	public List<Submission> getSubmissionDetails(@RequestParam int sessionId,@RequestParam int submissionId) {
		return submissionService.getSubmissionDetail(sessionId, submissionId);
	}
	
	@GetMapping("/getSubmission")
	public Optional<Submission> getSingleSubmissionDetails(@RequestParam int submissionQuestionId) {
		return submissionService.getSingleSubmission(submissionQuestionId);
	}
	
}
