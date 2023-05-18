package com.cafyf.code.entity;


import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="PROGRESS")
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Progress {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="ID")
private int id;
@Column(name="PROGRESS_ID")
private int progressId;

@Column(name="SESSION_ID")
private int sessionId;

@UpdateTimestamp
@JsonFormat(pattern = "MMMM dd, yyyy")
@Column(name="LAST_SOLVED_DATE")
private LocalDateTime  lastSolvedDate;

@Column(name="QUESTION")
private String question;
@Column(name="TOPIC")
private String topic;
@Column(name="MODE")
private String mode;
@Column(name="STATUS")
private String status;
@Column(name="SUBMISSION_QUESTION_ID")
private int submissionQuestionId;
}

