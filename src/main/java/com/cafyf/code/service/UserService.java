package com.cafyf.code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafyf.code.entity.User;
import com.cafyf.code.repository.UserRepository;

@Service
public class UserService {
	
	 @Autowired
	 UserRepository userRepo;
	 
	 @Autowired
	 SessionService sessionService;

	public User saveUser(User user) {
		
		if(userRepo.findByEmail(user.getEmail()) != null) {
			user.setEmail("Email already exist please use different");
			return user;
		}
		
		user.getUserProfile().setUserName(user.getName());
		user.getUserProfile().setStatus("beginner");
		User u=userRepo.save(user);
		System.out.println(u.toString());
		sessionService.setUp(u.getName(), u.getId());
		return u;
	}

	public User updateUser(User user, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getLogin(String email, String password) {
		return userRepo.findOneEmailAndPassword(email,password);
	}

	public Object getUserDetails(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
