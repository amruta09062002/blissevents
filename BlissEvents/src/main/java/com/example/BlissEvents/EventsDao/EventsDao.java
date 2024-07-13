package com.example.BlissEvents.EventsDao;

import java.time.LocalDate;
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
import com.example.BlissEvents.VenuesEntity.Venues;

@Repository
public class EventsDao {

	@Autowired
	SessionFactory factory;

	public boolean insertEvent(Events event) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(event);
			transaction.commit();
			return true;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return true;
	}

	public List<Events> getAllEvent() {
	    List<Events> eventList = null;
	    Session session = null;
	    try {
	        session = factory.openSession();
	        Transaction transaction = session.beginTransaction();
	        eventList = session.createQuery("from Events", Events.class).list();
	        transaction.commit();
	    } catch (Exception e) {
	    	EventsMessages.errorMessage();
	    } finally {
	        if (session != null) {
	            session.close(); 
	        }
	    }
	    return eventList;
	}



	public Events getEventById(Long eventId) {
		Session session = null;
		Events event = null;
		try {
			session = factory.openSession();
			event = session.get(Events.class, eventId);
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return event;
	}

	public List<Events> getEventByName(String eventName) {
		List<Events> event = null;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Events.class);
			criteria.add(Restrictions.eq("EventName", eventName));
			transaction.commit();
			event = criteria.list();
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return event;
	}

	public List<Events> getEventByDate(LocalDate eventDate) {
		List<Events> event = null;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Events.class);
			criteria.add(Restrictions.eq("EventDate", eventDate));
			transaction.commit();
			event = criteria.list();
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return event;
	}

	public boolean deleteEventById(Long eventId) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Events event = session.get(Events.class, eventId);
			session.delete(event);
			transaction.commit();
			return true;
		} catch (Exception e) {
			EventsMessages.NotDeleteIdMessage();
		}
		return true;
	}

	public boolean deleteEventByName(String eventName) {
		// List<Events> event = null;
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Events.class);
			criteria.add(Restrictions.eq("EventName", eventName));
			List<Events> event = criteria.list();
			for (Events evnt : event) {
				session.delete(evnt);
			}
			transaction.commit();
			// event = criteria.list();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			EventsMessages.errorMessage();
		}
		return true;
	}

	public boolean deleteEventByDate(LocalDate eventDate) {
		// List<Events> event = null;
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Events.class);
			criteria.add(Restrictions.eq("EventDate", eventDate));
			List<Events> event = criteria.list();
			for (Events evnt : event) {
				session.delete(evnt);
			}
			transaction.commit();
			// event = criteria.list();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return true;
	}

	public List<Events> deleteAllEvent(Events event) {
		List<Events> eventList = new ArrayList<>();
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			eventList = session.createQuery("from Events", Events.class).list();
			for (Events evnt : eventList) {
				session.delete(evnt);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			EventsMessages.errorMessage();
		}
		return eventList;
	}

	public String updateEventById(Long EventID, Events updatedEvent) {
		Transaction transaction = null;
		Events event = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			event = session.get(Events.class, EventID);
			if (event != null) {
				event.setEventName(updatedEvent.getEventName());
				event.setEventDate(updatedEvent.getEventDate());
				event.setVenue(updatedEvent.getVenue());
<<<<<<< HEAD
				event.setOrganizer(updatedEvent.getOrganizer());
=======
				event.setOrganizers(updatedEvent.getOrganizers());
>>>>>>> refs/remotes/origin/Akash
				session.update(event);
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

	public String updateEventByName(String EventName, Events updatedEvent) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Events.class);
			criteria.add(Restrictions.eq("EventName", EventName));
			List<Events> event = criteria.list();
			if (event != null && !event.isEmpty()) {
				for (Events evnt : event) {
					evnt.setEventName(updatedEvent.getEventName());
					evnt.setEventDate(updatedEvent.getEventDate());
					evnt.setVenue(updatedEvent.getVenue());
<<<<<<< HEAD
					evnt.setOrganizer(updatedEvent.getOrganizer());
=======
					evnt.setOrganizers(updatedEvent.getOrganizers());
>>>>>>> refs/remotes/origin/Akash
					session.update(evnt);
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

	public String updateEventByDate(LocalDate EventDate, Events updatedEvent) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Events.class);
			criteria.add(Restrictions.eq("EventDate", EventDate));
			List<Events> event = criteria.list();
			if (event != null && !event.isEmpty()) {
				for (Events evnt : event) {
					evnt.setEventName(updatedEvent.getEventName());
					evnt.setEventDate(updatedEvent.getEventDate());
					evnt.setVenue(updatedEvent.getVenue());
<<<<<<< HEAD
					evnt.setOrganizer(updatedEvent.getOrganizer());
=======
					evnt.setOrganizers(updatedEvent.getOrganizers());
>>>>>>> refs/remotes/origin/Akash
					session.update(evnt);
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

	public List<Events> getEventsBetweenDates(LocalDate fromDate, LocalDate toDate) {
		try (Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(Events.class);
			criteria.add(Restrictions.between("EventDate", fromDate, toDate));
			return criteria.list();
		} catch (Exception e) {
			return null;
		}
	}

	public List<Events> getEventsOrderedByName() {
		try (Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(Events.class);
			criteria.addOrder(Order.asc("EventName"));
			return criteria.list();
		} catch (Exception e) {
			return null;
		}
	}

	public List<Events> getEventsOrderedByDescName() {
		try (Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(Events.class);
			criteria.addOrder(Order.desc("EventName"));
			return criteria.list();
		} catch (Exception e) {
			return null;
		}
	}

	public List<Events> getEventsOrderedByDate() {
		try (Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(Events.class);
			criteria.addOrder(Order.asc("EventDate"));
			return criteria.list();
		} catch (Exception e) {
			return null;
		}
	}

	public List<Events> getEventsOrderedByDescDate() {
		try (Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(Events.class);
			criteria.addOrder(Order.desc("EventDate"));
			return criteria.list();
		} catch (Exception e) {
			return null;
		}
	}

}
