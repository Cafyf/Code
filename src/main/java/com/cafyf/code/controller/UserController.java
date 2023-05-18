package com.cafyf.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cafyf.code.entity.User;
import com.cafyf.code.service.UserService;

@CrossOrigin("http://localhost:8081")
@RestController
public class UserController {
	@Autowired
    UserService us;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		System.out.println("calling User to save...! "+user);
		return us.saveUser(user);
	}
	
	@PutMapping("/updateUser/{id}")
	public User updateUser(@RequestBody User user,@PathVariable("id") int id) {
		System.out.println("Calling User to Update Up Id...!");
		return us.updateUser(user,id);
	}
	
	@GetMapping("/login/email={email}&password={password}")
	public Object login(@PathVariable("email") String email, @PathVariable("password") String password) {

		return us.getLogin(email,password);
	}
	
	@GetMapping("/getUser/{id}")
	public Object findUserId(@PathVariable("id") int id)
	{
		 System.out.println("ID ....!  "+id);
		return us.getUserDetails(id);

	}	
	
}
