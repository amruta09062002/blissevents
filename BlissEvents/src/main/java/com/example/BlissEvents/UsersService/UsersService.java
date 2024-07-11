package com.example.BlissEvents.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.UsersDao.UsersDao;

@Service
public class UsersService {
	
	@Autowired
	private UsersDao userdao;
	

}
