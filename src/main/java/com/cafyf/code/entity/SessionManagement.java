package com.cafyf.code.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="SESSION_MANAGEMENT")
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class SessionManagement {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="SESSION_NAME")
	private String sessionName;
	
	@Column(name="MANAGE_ID")
	private int manageId;
}
