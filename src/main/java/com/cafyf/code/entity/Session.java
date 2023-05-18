package com.cafyf.code.entity;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="SESSION")
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Session {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="ID")
private int id;
@Column(name="SESSION_ID")
private int sessionId;
@Column(name="SESSION_NAME")
private String sessionName;
@Column(name="TOTAL_NO_OF_QUESTIONS_SOLVED")
private String totalQuestionsSolved;
@Column(name="MODE")
private String mode;
@Column(name="MANAGE_ID")
private int manageId;
}

