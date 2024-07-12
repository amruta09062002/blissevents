package com.example.BlissEvents.UsersController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/get-all-users")
	public ArrayList<Users> getAllUsers(Users user) {
		return userservice.getAllUsers(user);
	}

	@GetMapping("/get-user-by-id/{userId}")
	public Users getUsersById(@PathVariable("userId") Long userId) {
		return userservice.getUsersById(userId);
	}

	@GetMapping("/get-event-by-name/{userName}")
	public List<Users> getUsersByName(@PathVariable("userName") String userName) {
		return userservice.getUsersByName(userName);
	}
	
	@GetMapping("/get-event-by-fname/{firstName}")
	public List<Users> getUsersByFName(@PathVariable("firstName") String firstName) {
		return userservice.getUsersFByName(firstName);
	}
	
	@GetMapping("/get-event-by-lname/{lastName}")
	public List<Users> getUsersByLName(@PathVariable("lastName") String lastName) {
		return userservice.getUsersByLName(lastName);
	}

	@DeleteMapping("/delete-user-by-id/{userId}")
	public String deleteUsersById(@PathVariable("userId") Long userId) {
		return userservice.deleteUsersById(userId);
	}

	@DeleteMapping("/delete-user-by-name/{userName}")
	public String deleteUserByName(@PathVariable("userName") String userName) {
		return userservice.deleteUserByName(userName);
	}
	
	@DeleteMapping("/delete-event-by-fname/{firstName}")
	public List<Users> deleteUsersByFName(@PathVariable("firstName") String firstName) {
		return userservice.deleteUsersByFName(firstName);
	}
	
	@DeleteMapping("/delete-event-by-lname/{lastName}")
	public List<Users> deleteUsersByLName(@PathVariable("lastName") String lastName) {
		return userservice.deleteUsersByLName(lastName);
	}

	@DeleteMapping("/delete-all-users")
	public String deleteAllUsers(Users user) {
		return userservice.deleteAllUsers(user);
	}
	
	@PutMapping("/update-record-by-id/{userId}")
	public String updateUserById(@PathVariable Long userId, @RequestBody Users updatedUsers) {
		return userservice.updateUserById(userId,updatedUsers);
	}
	
	@PutMapping("/update-record-by-name/{userName}")
	public String updateUserByName(@PathVariable String userName, @RequestBody Users updatedUsers) {
		return userservice.updateUserByName(userName,updatedUsers);
	}
	
	@GetMapping("/ordered-by-name")
	public Object getUsersOrderedByUName() {
		return userservice.getUsersOrderedByUName();
	}
	
	@GetMapping("/ordered-by-name-desc")
	public Object getUsersOrderedByDescUName() {
		return userservice.getUsersOrderedByDescUName();
	}

}
