package com.example.BlissEvents.UsersEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long UserId;
	private String UserName;
	private String Password;
	private String email;
	private String FirstName;
	private String LastName;
	

}
