package com.example.BlissEvents.OrganizersDao;

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
import com.example.BlissEvents.OrganizersEntity.Organizers;
import com.example.BlissEvents.OrganizersMessages.OrganizersMessages;

@Repository
public class OrganizersDao {
	
	@Autowired
	SessionFactory factory;

	public boolean insertOrganizer(Organizers organizers) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(organizers);
			transaction.commit();
			return true;
		} catch (Exception e) {
			AttendeesMessages.errorMessage();
		}
		return true;
	}

	public List<Organizers> getAllOrganizers() {
		List<Organizers> organizersList = null;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			organizersList = session.createQuery("from Organizers", Organizers.class).list();
			transaction.commit();
		} catch (Exception e) {
			AttendeesMessages.errorMessage();
		}
		return organizersList;
	}

	public Organizers getOrganizerById(int id) {
	    Organizers organizers = null;
	    Session session = null;
	    try {
	        session = factory.openSession();
	        organizers = session.get(Organizers.class, id);
	        session.close();
	        return organizers;
	    } catch (Exception e) {
	        e.printStackTrace();  // Log the exception or handle it appropriately
	        AttendeesMessages.errorMessage();  // Assuming this is a custom method for error messaging
	    
	    }
	    return organizers;
	}


	public List<Organizers> getAttendeeByOrganizerName(String name) {
		List<Organizers> organizers = null;
		try {
			Session session = factory.openSession();
			Criteria criteria = session.createCriteria(Organizers.class);
			criteria.add(Restrictions.eq("organizerName", name));
			organizers = criteria.list();
		} catch (Exception e) {
			OrganizersMessages.errorMessage();
		}
		return organizers;
	}

	public Organizers getOrganizerByphoneNumber(String phone) {
		Organizers organizers = null;
		Session session = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Organizers.class);
			criteria.add(Restrictions.eq("phoneNumber", phone));
			organizers = (Organizers) criteria.uniqueResult();
		} catch (Exception e) {
			OrganizersMessages.errorMessage();
		}
		return organizers;
	}

	public boolean deleteOrganizerById(int id) {
		Transaction transaction = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			Organizers organizers = session.get(Organizers.class, id);
			if (organizers != null) {
				session.delete(organizers);
			} else {
				OrganizersMessages.nullValue();
			}
			transaction.commit();
			return true;

		} catch (Exception e) {
			AttendeesMessages.AttendeeNotDeleted();
		}
		return true;
	}

	public boolean deleteOrganizerByName(String name) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Organizers.class);
			criteria.add(Restrictions.eq("organizerName", name));
			Organizers organizers = (Organizers) criteria.uniqueResult();
			if (organizers != null) {
				session.delete(organizers);
				transaction.commit();
				return true;
			} else {
				OrganizersMessages.nullValue();
			}
		} catch (Exception e) {
			OrganizersMessages.OrganizerNotDeleted();
		}
		return true;
	}

	
	
	public boolean deleteOrganizerByphoneNumber(String phone) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Organizers.class);
			criteria.add(Restrictions.eq("phoneNumber", phone));
			Organizers organizers = (Organizers) criteria.uniqueResult();
			if (organizers != null) {
				session.delete(organizers);
				transaction.commit();
				return true;
			} else {
				OrganizersMessages.nullValue();
			}
		} catch (Exception e) {
			OrganizersMessages.OrganizerNotDeleted();
		}
		return true;
	}

	public boolean deleteAllOrganizers() {
		Transaction transaction = null;
		Session session = null;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Organizers> criteriaQuery = builder.createQuery(Organizers.class);
			Root<Organizers> root = criteriaQuery.from(Organizers.class);
			criteriaQuery.select(root);
			List<Organizers> organizersList = session.createQuery(criteriaQuery).getResultList();
			if (organizersList != null) {
				for (Organizers organizers : organizersList) {
					session.delete(organizers);
				}
			} else {
				OrganizersMessages.OrganizerNotDeleted();
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			OrganizersMessages.OrganizerNotDeleted();
		}
		return true;
	}

	public boolean updateOrganizerById(int id, Organizers updatedOrganizer) {
		Transaction transaction = null;
		Session session = null;
		boolean isUpdated = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();

			Organizers existingOrganizer = session.get(Organizers.class, id);
			if (existingOrganizer != null) {
				existingOrganizer.setOrganizerName(updatedOrganizer.getOrganizerName());
				existingOrganizer.setPhoneNumber(updatedOrganizer.getPhoneNumber());

				session.update(existingOrganizer);
				transaction.commit();
				isUpdated = true;
			} else {
				OrganizersMessages.nullValue();
			}
		} catch (Exception e) {
			OrganizersMessages.OrganizerNotupdated();
		}
		return isUpdated;
	}

	public boolean updateOrganizerByName(String name, Organizers updatedOrganizer) {
	    Transaction transaction = null;
	    Session session = null;
	    boolean isUpdated = false;

	    try {
	        session = factory.openSession();
	        transaction = session.beginTransaction();
	        
	        Organizers existingOrganizer = (Organizers) session.createQuery("FROM Organizers WHERE organizerName = :organizerName")
	                .setParameter("organizerName", name)
	                .uniqueResult();

	        if (existingOrganizer != null) {
	            existingOrganizer.setOrganizerName(updatedOrganizer.getOrganizerName());
	            existingOrganizer.setPhoneNumber(updatedOrganizer.getPhoneNumber());

	            session.update(existingOrganizer);
	            transaction.commit();
	            isUpdated = true;
	        } else {
	            OrganizersMessages.nullValue();
	        }
	    } catch (Exception e) {
	       
	        OrganizersMessages.OrganizerNotupdated();
	    } 
	    return isUpdated;
	}


	public boolean updateOrganizerByphoneNumber(String phone, Organizers updatedOrganizer) {
		Transaction transaction = null;
		Session session = null;
		boolean isUpdated = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Organizers existingOrganizer = (Organizers) session.createQuery("FROM Organizers WHERE phoneNumber = :phoneNumber")
					.setParameter("phoneNumber", phone).uniqueResult();

			if (existingOrganizer != null) {
				existingOrganizer.setOrganizerName(updatedOrganizer.getOrganizerName());
				existingOrganizer.setPhoneNumber(updatedOrganizer.getPhoneNumber());

				session.update(existingOrganizer);
				transaction.commit();
				isUpdated = true;
			} else {
				OrganizersMessages.nullValue();
			}
		} catch (Exception e) {
			OrganizersMessages.OrganizerNotupdated();
		}
		return isUpdated;
	}

	public List<Organizers> sortedByOrganizerName() {
		List<Organizers> organizersList = null;

        try {
        	Session  session = factory.openSession();
            Transaction transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Organizers.class);
            criteria.addOrder(Order.asc("organizerName"));

            organizersList = criteria.list();
            transaction.commit();
        } catch (Exception e) {
            OrganizersMessages.errorMessage();
        } 
        return organizersList;
	}

	
	

}
