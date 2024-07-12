package com.example.BlissEvents.PhotographerDao;

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
import com.example.BlissEvents.PhotographersEntity.Photographers;

@Repository
public class PhotographerDao {

    @Autowired
    private SessionFactory factory;

    public boolean addPhotographer(Photographers photographer) {
        try {
        	Session session = factory.openSession();
        	Transaction transaction = session.beginTransaction();
            session.save(photographer);
            transaction.commit();
            return true;
        } catch (Exception e) {
           AttendeesMessages.errorMessage();
        } 
        return true;
        
    }

	public List<Photographers> getAllPhotographers() {
		List<Photographers> photographersList = null;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			photographersList = session.createQuery("from Photographers", Photographers.class).list();
			transaction.commit();
		} catch (Exception e) {
			AttendeesMessages.errorMessage();
		}
		return photographersList;
	}

	public Photographers getPhotographerById(Long id) {
		Photographers photographers = null;
		try {
			Session session = factory.openSession();
			photographers = session.get(Photographers.class, id);
		} catch (Exception e) {
			AttendeesMessages.errorMessage();
		}
		return photographers;
	}

	public List<Photographers> getPhotographerByName(String name) {
		List<Photographers> photographers = null;
		try {
			Session session = factory.openSession();
			Criteria criteria = session.createCriteria(Photographers.class);
			criteria.add(Restrictions.eq("photographerName", name));
			photographers = criteria.list();
		} catch (Exception e) {
			AttendeesMessages.errorMessage();
		}
		return photographers;
	}

	public Photographers getPhotographerByPhoneNumber(String phone) {
		Photographers photographers = null;
		Session session = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Photographers.class);
			criteria.add(Restrictions.eq("contactInfo", phone));
			photographers = (Photographers) criteria.uniqueResult();
		} catch (Exception e) {
			AttendeesMessages.errorMessage();
		}
		return photographers;
	}

	public boolean deletePhotographerById(Long id) {
		Transaction transaction = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			Photographers photographers = session.get(Photographers.class, id);
			if (photographers != null) {
				session.delete(photographers);
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

	public boolean deletePhotographerByName(String name) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Photographers.class);
			criteria.add(Restrictions.eq("photographerName", name));
			Photographers photographers = (Photographers) criteria.uniqueResult();
			if (photographers != null) {
				session.delete(photographers);
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

	public boolean deletePhotographerByphoneNumber(String phone) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Photographers.class);
			criteria.add(Restrictions.eq("contactInfo", phone));
			Photographers photographers = (Photographers) criteria.uniqueResult();
			if (photographers != null) {
				session.delete(photographers);
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

	public boolean deleteAllPhotographers() {
		Transaction transaction = null;
		Session session = null;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Photographers> criteriaQuery = builder.createQuery(Photographers.class);
			Root<Photographers> root = criteriaQuery.from(Photographers.class);
			criteriaQuery.select(root);
			List<Photographers> photographersList = session.createQuery(criteriaQuery).getResultList();
			if (photographersList != null) {
				for (Photographers photographers : photographersList) {
					session.delete(photographers);
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

	public boolean updatePhotographerById(Long id, Photographers updatedPhotographer) {
		Transaction transaction = null;
		Session session = null;
		boolean isUpdated = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();

			Photographers existingPhotographer = session.get(Photographers.class, id);
			if (existingPhotographer != null) {
				existingPhotographer.setPhotographerName(updatedPhotographer.getPhotographerName());
				existingPhotographer.setContactInfo(updatedPhotographer.getContactInfo());

				session.update(existingPhotographer);
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

	public boolean updatePhotographerByName(String name, Photographers updatedPhotographer) {
		Transaction transaction = null;
		Session session = null;
		boolean isUpdated = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Photographers existingPhotographer = (Photographers) session.createQuery("FROM Photographers WHERE photographerName = :photographerName")
					.setParameter("photographerName", name).uniqueResult();

			if (existingPhotographer != null) {
				existingPhotographer.setPhotographerName(updatedPhotographer.getPhotographerName());
				existingPhotographer.setContactInfo(updatedPhotographer.getContactInfo());

				session.update(existingPhotographer);
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

	public boolean updatePhotographerByphoneNumber(String phone, Photographers updatedPhotographer) {
		Transaction transaction = null;
		Session session = null;
		boolean isUpdated = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Photographers existingPhotographer = (Photographers) session.createQuery("FROM Photographers WHERE contactInfo = :contactInfo")
					.setParameter("contactInfo", phone).uniqueResult();

			if (existingPhotographer != null) {
				existingPhotographer.setPhotographerName(updatedPhotographer.getPhotographerName());
				existingPhotographer.setContactInfo(updatedPhotographer.getContactInfo());

				session.update(existingPhotographer);
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

	public List<Photographers> getPhotographersSortByName() {
		List<Photographers> photographersList = null;

        try {
        	Session  session = factory.openSession();
            Transaction transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Photographers.class);
            criteria.addOrder(Order.asc("photographerName"));

            photographersList = criteria.list();
            transaction.commit();
        } catch (Exception e) {
            AttendeesMessages.errorMessage();
        } 
        return photographersList;
	}

	
}
