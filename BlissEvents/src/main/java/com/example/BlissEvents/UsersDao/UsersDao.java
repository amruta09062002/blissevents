package com.example.BlissEvents.UsersDao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BlissEvents.UsersEntity.Users;
import com.example.BlissEvents.UsersMessages.Messages;

@Repository
public class UsersDao {
	
	@Autowired 
	SessionFactory factory;

	public boolean insertUser(Users user) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			session.close();
			return true;
		}catch (Exception e) {
			 Messages.errorMessage();
		}
		return true;
	}

}
