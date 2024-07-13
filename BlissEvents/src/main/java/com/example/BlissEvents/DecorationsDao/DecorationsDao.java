package com.example.BlissEvents.DecorationsDao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.BlissEvents.DecorationsEntity.Decorations;
import com.example.BlissEvents.EventsMessages.EventsMessages;

@Repository
public class DecorationsDao {

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
		ArrayList<Decorations> decorationslist = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Decorations.class);
			decorationslist = (ArrayList<Decorations>) criteria.list();
			transaction.commit();
			session.close();
			// return decorationslist;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return decorationslist;
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
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Decorations.class);
			criteria.add(Restrictions.eq("decorationType", decorationType));
			dList = criteria.list();
			transaction.commit();
			session.close();
//			return dList;
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
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Decorations.class);
			criteria.add(Restrictions.eq("decorationBrand", decorationBrand));
			dList = criteria.list();
			transaction.commit();
			session.close();
//			return dList;
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

	public boolean deleteDecorationByType(String decorationType) {
		List<Decorations> dlist = null;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Decorations.class);
			criteria.add(Restrictions.eq("decorationType", decorationType));
			dlist = criteria.list();
			for (Decorations decoration : dlist) {
				session.delete(decoration);
			}
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return true;
	}

	public boolean deleteDecorationByBrand(String decorationBrand) {
		List<Decorations> dlist = null;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Decorations.class);
			criteria.add(Restrictions.eq("decorationBrand", decorationBrand));
			dlist = criteria.list();
			for (Decorations decoration : dlist) {
				session.delete(decoration);
			}
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
		List<Decorations> decoration = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Decorations.class);
			criteria.add(Restrictions.eq("decorationType", decorationType));
			decoration = criteria.list();
			if (decoration != null) {
				for (Decorations decorations : decoration) {
					decorations.setDecorationBrand(updatedecorations.getDecorationBrand());
					decorations.setEvents(updatedecorations.getEvents());
					session.update(decorations);
				}
				transaction.commit();
				session.close();
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
		List<Decorations> decoration = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Decorations.class);
			criteria.add(Restrictions.eq("decorationBrand", decorationBrand));
			decoration = criteria.list();
			if (decoration != null) {
				for (Decorations decorations : decoration) {
					decorations.setDecorationType(updatedecorations.getDecorationType());
					decorations.setEvents(updatedecorations.getEvents());
					session.update(decorations);
				}
				transaction.commit();
				session.close();
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
}
