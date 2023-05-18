package com.cafyf.code.entity;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="USERPROFILE")
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class UserProfile {
	
@Id    
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="PROFILE_ID")
private int userProfile;
@Column(name="USER_NAME")
private String userName;
@Column(name="STATUS", columnDefinition = "VARCHAR(20)")
private String Status;

}
