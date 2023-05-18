package com.cafyf.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafyf.code.entity.Progress;
import com.cafyf.code.service.ProgressService;

@CrossOrigin("http://localhost:8081")
@RestController
public class ProgressController {
	
	@Autowired
	ProgressService progressService;

	@GetMapping("/progressDetails")
	public List<Progress> getProgressdetails(@RequestParam int sessionId,@RequestParam int progressId) {
		return progressService.getProgressDetails(sessionId, progressId);
	}
}
