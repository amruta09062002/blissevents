package com.example.BlissEvents.UsersController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlissEvents.UsersService.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	private UsersService userservice;

}
