package com.example.BlissEvents.AttendeesDao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BlissEvents.AttendeesEntity.Attendees;
import com.example.BlissEvents.AttendeesMessages.AttendeesMessages;

@Repository
public class AttendeesDao {

	@Autowired
	SessionFactory factory;

	public boolean insertAttendee(Attendees attendees) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(attendees);
			transaction.commit();
			return true;
		} catch (Exception e) {
			AttendeesMessages.errorMessage();
		}
		return true;
	}

	public List<Attendees> getAllAttendees() {
		List<Attendees> attendeesList = null;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			attendeesList = session.createQuery("from Attendees", Attendees.class).list();
			transaction.commit();
		} catch (Exception e) {
			AttendeesMessages.errorMessage();
		}
		return attendeesList;

	}

	public Attendees getAttendeeById(Long id) {
		Attendees attendee = null;
		try {
			Session session = factory.openSession();
			attendee = session.get(Attendees.class, id);
		} catch (Exception e) {
			AttendeesMessages.errorMessage();
		}
		return attendee;
	}

	public List<Attendees> getAttendeeByFirstName(String fname) {
		List<Attendees> attendees = null;
		try {
			Session session = factory.openSession();
			Criteria criteria = session.createCriteria(Attendees.class);
			criteria.add(Restrictions.eq("firstName", fname));
			attendees = criteria.list();
		} catch (Exception e) {
			AttendeesMessages.errorMessage();
		}
		return attendees;
	}

	public List<Attendees> getAttendeeByLastName(String lname) {
		List<Attendees> attendees = null;
		try {
			Session session = factory.openSession();
			Criteria criteria = session.createCriteria(Attendees.class);
			criteria.add(Restrictions.eq("lastName", lname));
			attendees = criteria.list();
		} catch (Exception e) {
			AttendeesMessages.errorMessage();
		}
		return attendees;
	}

	public Attendees getAttendeeByPhoneNumber(String phone) {
		Attendees attendee = null;
		Session session = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Attendees.class);
			criteria.add(Restrictions.eq("phoneNumber", phone));
			attendee = (Attendees) criteria.uniqueResult();
		} catch (Exception e) {
			AttendeesMessages.errorMessage();
		}
		return attendee;
	}

	public boolean deleteAttendeeById(Long id) {
		Transaction transaction = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			Attendees attendee = session.get(Attendees.class, id);
			if (attendee != null) {
				session.delete(attendee);
			} else {
				AttendeesMessages.nullValue();
			}
			transaction.commit();
			return true;

		} catch (Exception e) {
			AttendeesMessages.AttendeeNotDeleted();
		}
		return true;
	}

	public boolean deleteAttendeeByFirstName(String fname) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Attendees.class);
			criteria.add(Restrictions.eq("firstName", fname));
			Attendees attendee = (Attendees) criteria.uniqueResult();
			if (attendee != null) {
				session.delete(attendee);
				transaction.commit();
				return true;
			} else {
				AttendeesMessages.nullValue();
			}
		} catch (Exception e) {
			AttendeesMessages.AttendeeNotDeleted();
		}
		return true;
	}

	public boolean deleteAttendeeByLastName(String lname) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Attendees.class);
			criteria.add(Restrictions.eq("lastName", lname));
			Attendees attendee = (Attendees) criteria.uniqueResult();
			if (attendee != null) {
				session.delete(attendee);
				transaction.commit();
				return true;
			} else {
				AttendeesMessages.nullValue();
			}
		} catch (Exception e) {
			AttendeesMessages.AttendeeNotDeleted();
		}
		return true;
	}

	public boolean deleteAttendeeByphoneNumber(String phone) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Attendees.class);
			criteria.add(Restrictions.eq("phoneNumber", phone));
			Attendees attendee = (Attendees) criteria.uniqueResult();
			if (attendee != null) {
				session.delete(attendee);
				transaction.commit();
				return true;
			} else {
				AttendeesMessages.nullValue();
			}
		} catch (Exception e) {
			AttendeesMessages.AttendeeNotDeleted();
		}
		return true;
	}

	public boolean deleteAllAttendees() {
		Transaction transaction = null;
		Session session = null;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Attendees> criteriaQuery = builder.createQuery(Attendees.class);
			Root<Attendees> root = criteriaQuery.from(Attendees.class);
			criteriaQuery.select(root);
			List<Attendees> attendeesList = session.createQuery(criteriaQuery).getResultList();
			if (attendeesList != null) {
				for (Attendees attendee : attendeesList) {
					session.delete(attendee);
				}
			} else {
				AttendeesMessages.AttendeeNotDeleted();
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			AttendeesMessages.AttendeeNotDeleted();
		}
		return true;
	}

	public boolean updateAttendeeById(Long id, Attendees updatedAttendee) {
		Transaction transaction = null;
		Session session = null;
		boolean isUpdated = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();

			Attendees existingAttendee = session.get(Attendees.class, id);
			if (existingAttendee != null) {
				existingAttendee.setFirstName(updatedAttendee.getFirstName());
				existingAttendee.setLastName(updatedAttendee.getLastName());
				existingAttendee.setEmail(updatedAttendee.getEmail());
				existingAttendee.setPhoneNumber(updatedAttendee.getPhoneNumber());

				session.update(existingAttendee);
				transaction.commit();
				isUpdated = true;
			} else {
				AttendeesMessages.nullValue();
			}
		} catch (Exception e) {
			AttendeesMessages.AttendeeNotupdated();
		}
		return isUpdated;
	}

	public boolean updateAttendeeByFirstName(String name, Attendees updatedAttendee) {
		Transaction transaction = null;
		Session session = null;
		boolean isUpdated = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Attendees existingAttendee = (Attendees) session.createQuery("FROM Attendees WHERE firstName = :firstName")
					.setParameter("firstName", name).uniqueResult();

			if (existingAttendee != null) {
				existingAttendee.setFirstName(updatedAttendee.getFirstName());
				existingAttendee.setLastName(updatedAttendee.getLastName());
				existingAttendee.setEmail(updatedAttendee.getEmail());
				existingAttendee.setPhoneNumber(updatedAttendee.getPhoneNumber());

				session.update(existingAttendee);
				transaction.commit();
				isUpdated = true;
			} else {
				AttendeesMessages.nullValue();
			}
		} catch (Exception e) {
			AttendeesMessages.AttendeeNotupdated();
		}
		return isUpdated;
	}

	public boolean updateAttendeeByLastName(String lname, Attendees updatedAttendee) {
		Transaction transaction = null;
		Session session = null;
		boolean isUpdated = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Attendees existingAttendee = (Attendees) session.createQuery("FROM Attendees WHERE lastName = :lastName")
					.setParameter("lastName", lname).uniqueResult();

			if (existingAttendee != null) {
				existingAttendee.setFirstName(updatedAttendee.getFirstName());
				existingAttendee.setLastName(updatedAttendee.getLastName());
				existingAttendee.setEmail(updatedAttendee.getEmail());
				existingAttendee.setPhoneNumber(updatedAttendee.getPhoneNumber());

				session.update(existingAttendee);
				transaction.commit();
				isUpdated = true;
			} else {
				AttendeesMessages.nullValue();
			}
		} catch (Exception e) {
			AttendeesMessages.AttendeeNotupdated();
		}
		return isUpdated;
	}

	public boolean updateAttendeeByphoneNumber(String phone, Attendees updatedAttendee) {
		Transaction transaction = null;
		Session session = null;
		boolean isUpdated = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Attendees existingAttendee = (Attendees) session.createQuery("FROM Attendees WHERE phoneNumber = :phoneNumber")
					.setParameter("phoneNumber", phone).uniqueResult();

			if (existingAttendee != null) {
				existingAttendee.setFirstName(updatedAttendee.getFirstName());
				existingAttendee.setLastName(updatedAttendee.getLastName());
				existingAttendee.setEmail(updatedAttendee.getEmail());
				existingAttendee.setPhoneNumber(updatedAttendee.getPhoneNumber());

				session.update(existingAttendee);
				transaction.commit();
				isUpdated = true;
			} else {
				AttendeesMessages.nullValue();
			}
		} catch (Exception e) {
			AttendeesMessages.AttendeeNotupdated();
		}
		return isUpdated;
	}

	public List<Attendees> getAttendeesSortedByFirstName() {
	        List<Attendees> attendeesList = null;

	        try {
	        	Session  session = factory.openSession();
	            Transaction transaction = session.beginTransaction();
	            Criteria criteria = session.createCriteria(Attendees.class);
	            criteria.addOrder(Order.asc("firstName"));

	            attendeesList = criteria.list();
	            transaction.commit();
	        } catch (Exception e) {
	            AttendeesMessages.errorMessage();
	        } 
	        return attendeesList;
	    }

}
