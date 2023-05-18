package com.cafyf.code.controller.etities;

import com.cafyf.code.entity.Progress;
import com.cafyf.code.entity.Session;
import com.cafyf.code.entity.Submission;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString  
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Submissions {

	@JsonProperty("submission")
	private Submission submission;
	
    @JsonProperty("progress")
	private Progress progress;
    
    @JsonProperty("session")
    private Session session;
}
