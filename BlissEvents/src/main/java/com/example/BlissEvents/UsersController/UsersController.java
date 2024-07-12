package com.example.BlissEvents.UsersController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlissEvents.UsersEntity.Users;
import com.example.BlissEvents.UsersService.UsersService;

@RestController
@RequestMapping("/api/Users")
public class UsersController {
	
	@Autowired
	private UsersService userservice;
	
	@PostMapping("/insert")
	public void insertUser(@RequestBody Users user) {
		userservice.insertUser(user);
	}

}
