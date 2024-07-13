package com.example.BlissEvents.CateringsDao;

import java.util.ArrayList;
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

import com.example.BlissEvents.AttendeesMessages.AttendeesMessages;
import com.example.BlissEvents.CateringsEntity.Caterings;

@Repository
public class CateringsDao {
	
	@Autowired
	private SessionFactory factory;

	public boolean insertCatering(Caterings caterings) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(caterings);
			transaction.commit();
			return true;
		} catch (Exception e) {
			AttendeesMessages.errorMessage();
		}
		return true;
	}

	public ArrayList<Caterings> getAllCaterings() {
		ArrayList<Caterings> cateringsList = null;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			cateringsList = (ArrayList<Caterings>) session.createQuery("from Caterings", Caterings.class).list();
			transaction.commit();
		} catch (Exception e) {
			//AttendeesMessages.errorMessage();
			e.printStackTrace();
		}
		return cateringsList;
	}

	public Caterings getCateringById(Long id) {
		Caterings caterings = null;
		try {
			Session session = factory.openSession();
			caterings = session.get(Caterings.class, id);
		} catch (Exception e) {
			AttendeesMessages.errorMessage();
		}
		return caterings;
	}

	public List<Caterings> getCateringByName(String name) {
		List<Caterings> caterings = null;
		try {
			Session session = factory.openSession();
			Criteria criteria = session.createCriteria(Caterings.class);
			criteria.add(Restrictions.eq("cateringName", name));
			caterings = criteria.list();
		} catch (Exception e) {
			AttendeesMessages.errorMessage();
		}
		return caterings;
	}

	public Caterings getCateringByPhoneNumber(String phone) {
		Caterings caterings = null;
		Session session = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Caterings.class);
			criteria.add(Restrictions.eq("contactInfo", phone));
			caterings = (Caterings) criteria.uniqueResult();
		} catch (Exception e) {
			AttendeesMessages.errorMessage();
		}
		return caterings;
	}

	public boolean deleteCateringById(Long id) {
		Transaction transaction = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			Caterings caterings = session.get(Caterings.class, id);
			if (caterings != null) {
				session.delete(caterings);
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

	public boolean deleteCateringByName(String name) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Caterings.class);
			criteria.add(Restrictions.eq("cateringName", name));
			Caterings caterings = (Caterings) criteria.uniqueResult();
			if (caterings != null) {
				session.delete(caterings);
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

	public boolean deleteCateringByphoneNumber(String phone) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Caterings.class);
			criteria.add(Restrictions.eq("contactInfo", phone));
			Caterings caterings = (Caterings) criteria.uniqueResult();
			if (caterings != null) {
				session.delete(caterings);
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

	public boolean deleteAllCaterings() {
		Transaction transaction = null;
		Session session = null;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Caterings> criteriaQuery = builder.createQuery(Caterings.class);
			Root<Caterings> root = criteriaQuery.from(Caterings.class);
			criteriaQuery.select(root);
			List<Caterings> cateringsList = session.createQuery(criteriaQuery).getResultList();
			if (cateringsList != null) {
				for (Caterings caterings : cateringsList) {
					session.delete(caterings);
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

	public boolean updateCateringById(Long id, Caterings updatedCatering) {
		Transaction transaction = null;
		Session session = null;
		boolean isUpdated = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();

			Caterings existingCatering = session.get(Caterings.class, id);
			if (existingCatering != null) {
				existingCatering.setCateringName(updatedCatering.getCateringName());
				existingCatering.setCateringMenu(updatedCatering.getCateringMenu());
				existingCatering.setContactInfo(updatedCatering.getContactInfo());
				existingCatering.setEvent(updatedCatering.getEvent());

				session.update(existingCatering);
				transaction.commit();
				session.close();
				isUpdated = true;
			} else {
				AttendeesMessages.nullValue();
			}
		} catch (Exception e) {
			AttendeesMessages.AttendeeNotupdated();
		}
		return isUpdated;
	}

	public boolean updateCateringByName(String name, Caterings updatedCatering) {
		Transaction transaction = null;
		Session session = null;
		boolean isUpdated = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Caterings existingCatering  = (Caterings) session.createQuery("FROM Caterings WHERE cateringName = :cateringName")
					.setParameter("cateringName", name).uniqueResult();

			if (existingCatering != null) {
				existingCatering.setCateringName(updatedCatering.getCateringName());
				existingCatering.setCateringMenu(updatedCatering.getCateringMenu());
				existingCatering.setContactInfo(updatedCatering.getContactInfo());
				existingCatering.setEvent(updatedCatering.getEvent());
				
				session.update(existingCatering);
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

	public boolean updateCateringByphoneNumber(String phone, Caterings updatedCatering) {
		Transaction transaction = null;
		Session session = null;
		boolean isUpdated = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Caterings existingCatering  = (Caterings) session.createQuery("FROM Caterings WHERE contactInfo = :contactInfo")
					.setParameter("contactInfo", phone).uniqueResult();

			if (existingCatering != null) {
				existingCatering.setCateringName(updatedCatering.getCateringName());
				existingCatering.setCateringMenu(updatedCatering.getCateringMenu());
				existingCatering.setContactInfo(updatedCatering.getContactInfo());
				existingCatering.setEvent(updatedCatering.getEvent());
				
				session.update(existingCatering);
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

	public List<Caterings> getCateringsSortByName() {
		 List<Caterings> cateringsList = null;

	        try {
	        	Session  session = factory.openSession();
	            Transaction transaction = session.beginTransaction();
	            Criteria criteria = session.createCriteria(Caterings.class);
	            criteria.addOrder(Order.asc("cateringName"));

	            cateringsList = criteria.list();
	            transaction.commit();
	        } catch (Exception e) {
	            AttendeesMessages.errorMessage();
	        } 
	        return cateringsList;
	}

}
