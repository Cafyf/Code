package com.cafyf.code.entity;



import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="USER")
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class User {
	
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="USER_ID")
private int id;
@Column(name="USER_NAME")
private String name;
@Column(name="USER_EMAIL")
private String email;
@Column(name="PASSWORD")
private String password;

@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
@JoinColumn(name="USERPROFILE_ID")
private UserProfile userProfile;

}

