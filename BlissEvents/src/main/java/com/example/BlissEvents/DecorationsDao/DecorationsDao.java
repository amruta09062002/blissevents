package com.example.BlissEvents.DecorationsDao;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BlissEvents.DecorationsEntity.Decorations;
import com.example.BlissEvents.EventsEntity.Events;
import com.example.BlissEvents.EventsMessages.EventsMessages;

@Repository
>>>>>>> refs/remotes/origin/Akash
public class DecorationsDao {

<<<<<<< HEAD
=======
	@Autowired
	SessionFactory factory;

	public boolean insertDecoations(Decorations decorations) {

		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(decorations);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return true;
	}

	public ArrayList<Decorations> getAllDecorations(Decorations decorations) {
		Session session = null;
		ArrayList<Decorations> deArrayList = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Decorations.class);
			deArrayList = (ArrayList<Decorations>) criteria.list();
			session.close();
			return deArrayList;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return deArrayList;
	}

	public Decorations getDecorationById(Long decorationId) {
		Session session = null;
		Decorations decorations = null;
		try {
			session = factory.openSession();
			decorations = session.get(Decorations.class, decorationId);
			session.close();
			return decorations;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return decorations;
	}

	public List<Decorations> getEventByType(String decorationType) {
		Session session = null;
		List<Decorations> dList = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Decorations.class, decorationType);
			dList = criteria.list();
			session.close();
			return dList;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return dList;
	}

	public List<Decorations> getEventByBrand(String decorationBrand) {

		Session session = null;
		List<Decorations> dList = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Decorations.class, decorationBrand);
			dList = criteria.list();
			session.close();
			return dList;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return dList;
	}

	public boolean deleteDecorationById(Long decorationId) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Decorations decorations = session.load(Decorations.class, decorationId);
			session.delete(decorations);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return true;
	}

	public boolean deleteDecorationByType(Long decorationType) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Decorations decorations = session.load(Decorations.class, decorationType);
			session.delete(decorations);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return true;
	}

	public boolean deleteDecorationByBrand(Long decorationBrand) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Decorations decorations = session.load(Decorations.class, decorationBrand);
			session.delete(decorations);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return true;
	}

	public boolean deleteAllDecorations(Decorations decorations) {
		Transaction transaction = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			session.delete(decorations);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		}
		return true;
	}

	public String updateDecorationById(Long decorationId, Decorations updatedecorations) {
		Transaction transaction = null;
		Decorations decorations = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			decorations = session.get(Decorations.class, decorationId);
			if (decorations != null) {
				decorations.setDecorationType(updatedecorations.getDecorationType());
				decorations.setDecorationBrand(updatedecorations.getDecorationBrand());
				decorations.setEvents(updatedecorations.getEvents());
				session.update(decorations);
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

	public Object updateDecorationByType(String decorationType, Decorations updatedecorations) {

		Transaction transaction = null;
		Decorations decorations = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			decorations = session.get(Decorations.class, decorationType);
			if (decorations != null) {
				decorations.setDecorationBrand(updatedecorations.getDecorationBrand());
				decorations.setEvents(updatedecorations.getEvents());
				session.update(decorations);
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

	public Object updateDecorationByBrand(String decorationBrand, Decorations updatedecorations) {
		Transaction transaction = null;
		Decorations decorations = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			decorations = session.get(Decorations.class, decorationBrand);
			if (decorations != null) {
				decorations.setDecorationType(updatedecorations.getDecorationType());
				decorations.setEvents(updatedecorations.getEvents());
				session.update(decorations);
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
>>>>>>> refs/remotes/origin/Akash
}
