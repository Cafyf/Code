package com.cafyf.code.entity;


import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="SUBMISSION")
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Submission {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="ID")
private int id;
@Column(name="SUBMISSION_ID")
private int submissionId;

@Column(name="SESSION_ID")
private int sessionId;

@CreationTimestamp
@Column(name="TIME_SUBMITTED")
private LocalDateTime  timeSubmitted;

@Column(name="QUESTION")
private String question;
@Column(name="STATUS")
private String status;
@Column(name="RUNTIME")
private String runtime;
@Column(name="LANGUAGE")
private String language;
@Column(name="SUBMITTED_QUESTION")
private String submittedQuestion;

@Column(name="TOPIC")
private String topic;
}

