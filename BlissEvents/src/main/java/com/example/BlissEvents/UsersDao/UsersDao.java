package com.example.BlissEvents.UsersDao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BlissEvents.EventsEntity.Events;
import com.example.BlissEvents.EventsMessages.EventsMessages;
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

	public ArrayList<Users> getAllUsers(Users user) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			ArrayList<Users> userList = (ArrayList<Users>) session.createQuery("from Users", Users.class).list();
			transaction.commit();
			return userList;
		} catch (Exception e) {
			//EventsMessages.errorMessage();
			e.printStackTrace();
		}
		return null;
	}

	public Users getUsersById(Long userId) {
		Session session = null;
		Users user = null;
		try {
			session = factory.openSession();
			user = session.get(Users.class, userId);
		} catch (Exception e) {
			//EventsMessages.errorMessage();
			e.printStackTrace();
		}
		return user;
	}

	public List<Users> getUsersByName(String userName) {
		List<Users> user = null;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Events.class);
			criteria.add(Restrictions.eq("userName", userName));
			transaction.commit();
			user = criteria.list();
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return user;
	}

	public List<Users> getUsersFByName(String firstName) {
		List<Users> user = null;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Users.class);
			criteria.add(Restrictions.eq("firstName", firstName));
			transaction.commit();
			user = criteria.list();
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return user;
	}

	public List<Users> getUsersByLName(String lastName) {
		List<Users> user = null;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Users.class);
			criteria.add(Restrictions.eq("lastName", lastName));
			transaction.commit();
			user = criteria.list();
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return user;
	}

	public boolean deleteUsersById(Long userId) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Users user = session.get(Users.class, userId);
			session.delete(user);
			transaction.commit();
			return true;
		} catch (Exception e) {
			EventsMessages.NotDeleteIdMessage();
		}
		return true;
	}

	public boolean deleteUserByName(String userName) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Users.class);
			criteria.add(Restrictions.eq("userName", userName));
			List<Users> user = criteria.list();
			for (Users usr : user) {
				session.delete(usr);
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			EventsMessages.errorMessage();
		}
		return true;
	}

	public List<Users> deleteUsersByFName(String firstName) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Users.class);
			criteria.add(Restrictions.eq("firstName", firstName));
			List<Users> user = criteria.list();
			for (Users usr : user) {
				session.delete(usr);
			}
			transaction.commit();
			return null;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			EventsMessages.errorMessage();
		}
		return null;
	}

	public List<Users> deleteUsersByLName(String lastName) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Users.class);
			criteria.add(Restrictions.eq("lastName", lastName));
			List<Users> user = criteria.list();
			for (Users usr : user) {
				session.delete(usr);
			}
			transaction.commit();
			return null;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			EventsMessages.errorMessage();
		}
		return null;
	}

	public Object deleteAllUsers(Users user) {
		List<Users> userList = new ArrayList<>();
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			userList = session.createQuery("from Users", Users.class).list();
			for (Users usr : userList) {
				session.delete(usr);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			EventsMessages.errorMessage();
		}
		return userList;
	}

	public Object updateUserById(Long userId, Users updatedUsers) {
		Transaction transaction = null;
		Users user = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			user = session.get(Users.class, userId);
			if (user != null) {
				user.setUserId(updatedUsers.getUserId());
				user.setUserName(updatedUsers.getUserName());
				user.setPassword(updatedUsers.getPassword());
				user.setOrganizer(updatedUsers.getOrganizer());
				user.setEmail(updatedUsers.getEmail());
				user.setEvent(updatedUsers.getEvent());
				user.setFirstName(updatedUsers.getFirstName());
				user.setLastName(updatedUsers.getLastName());
				session.update(user);
				transaction.commit();
				return EventsMessages.updatedMessage();
			} else {
				return EventsMessages.notUpdatedMessage();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return EventsMessages.errorMessage();
		}
	}

	public String updateUserByName(String userName, Users updatedUsers) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Events.class);
			criteria.add(Restrictions.eq("userName", userName));
			List<Users> user = criteria.list();
			if (user != null && !user.isEmpty()) {
				for (Users usr : user) {
					usr.setUserId(updatedUsers.getUserId());
					usr.setUserName(updatedUsers.getUserName());
					usr.setPassword(updatedUsers.getPassword());
					usr.setOrganizer(updatedUsers.getOrganizer());
					usr.setEmail(updatedUsers.getEmail());
					usr.setEvent(updatedUsers.getEvent());
					usr.setFirstName(updatedUsers.getFirstName());
					usr.setLastName(updatedUsers.getLastName());
					session.update(usr);
				}
				transaction.commit();
				return EventsMessages.updatedMessage();
			} else {
				return EventsMessages.notUpdatedMessage();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return EventsMessages.errorMessage();
		}
	}

	public List<Users> getUsersOrderedByUName() {
		try (Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(Users.class);
			criteria.addOrder(Order.asc("userName"));
			return criteria.list();
		} catch (Exception e) {
			return null;
		}
	}

	public List<Users> getUsersOrderedByDescUName() {
		try (Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(Users.class);
			criteria.addOrder(Order.desc("userName"));
			return criteria.list();
		} catch (Exception e) {
			return null;
		}
	}

}
