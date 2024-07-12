package com.example.BlissEvents.UsersService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.EventsEntity.Events;
import com.example.BlissEvents.EventsMessages.EventsMessages;
import com.example.BlissEvents.UsersDao.UsersDao;
import com.example.BlissEvents.UsersEntity.Users;

@Service
public class UsersService {
	
	@Autowired
	private UsersDao userdao;

	public String insertUser(Users user) {
		if (userdao.insertUser(user)) {
			return EventsMessages.insertMessage();
		} else {
			return EventsMessages.notInsertMessage();
		}
	}

	public ArrayList<Users> getAllUsers(Users user) {
		return userdao.getAllUsers(user);
	}

	public Users getUsersById(Long userId) {
		if (userdao.getUsersById(userId) != null) {
			return userdao.getUsersById(userId);
		} else {
			EventsMessages.idNotFound();
		}
		return null;
	}

	public List<Users> getUsersByName(String userName) {
		if (userdao.getUsersByName(userName) != null) {
			return userdao.getUsersByName(userName);
		} else {
			EventsMessages.EventNotFound();
		}
		return null;
	}

	public List<Users> getUsersFByName(String firstName) {
		if (userdao.getUsersFByName(firstName) != null) {
			return userdao.getUsersFByName(firstName);
		} else {
			EventsMessages.EventNotFound();
		}
		return null;
	}

	public List<Users> getUsersByLName(String lastName) {
		if (userdao.getUsersByLName(lastName) != null) {
			return userdao.getUsersByLName(lastName);
		} else {
			EventsMessages.EventNotFound();
		}
		return null;
	}

	public String deleteUsersById(Long userId) {
		if (userdao.deleteUsersById(userId)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

	public String deleteUserByName(String userName) {
		if (userdao.deleteUserByName(userName)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

	public List<Users> deleteUsersByFName(String firstName) {
		if (userdao.deleteUsersByFName(firstName) != null) {
			return userdao.deleteUsersByFName(firstName);
		} else {
			EventsMessages.EventNotFound();
		}
		return null;
	}

	public List<Users> deleteUsersByLName(String lastName) {
		if (userdao.deleteUsersByLName(lastName) != null) {
			return userdao.deleteUsersByLName(lastName);
		} else {
			EventsMessages.EventNotFound();
		}
		return null;
	}

	public String deleteAllUsers(Users user) {
		if (userdao.deleteAllUsers(user) != null) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.EvenDatetNotFound();
		}
	}

	public String updateUserById(Long userId, Users updatedUsers) {
		if (userdao.updateUserById(userId, updatedUsers) != null) {
			return EventsMessages.updatedMessage();
		} else {
			return EventsMessages.notUpdatedMessage();
		}
	}

	public String updateUserByName(String userName, Users updatedUsers) {
		if (userdao.updateUserByName(userName, updatedUsers) != null) {
			return EventsMessages.updatedMessage();
		} else {
			return EventsMessages.notUpdatedMessage();
		}
	}

	public Object getUsersOrderedByUName() {
		List<Users> user = userdao.getUsersOrderedByUName();
		if(user != null && !user.isEmpty()) {
			return user;
		}else {
			return EventsMessages.errorMessage();
		}
	}

	public Object getUsersOrderedByDescUName() {
		List<Users> user = userdao.getUsersOrderedByDescUName();
		if(user != null && !user.isEmpty()) {
			return user;
		}else {
			return EventsMessages.errorMessage();
		}
	}
	

}
