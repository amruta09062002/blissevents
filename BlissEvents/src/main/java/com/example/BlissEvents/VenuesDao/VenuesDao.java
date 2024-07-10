package com.example.BlissEvents.VenuesDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BlissEvents.EventsEntity.Events;
import com.example.BlissEvents.EventsMessages.EventsMessages;
import com.example.BlissEvents.VenuesEntity.Venues;

@Repository
public class VenuesDao {

	@Autowired
	SessionFactory factory;

	public boolean insertVenues(Venues venue) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(venue);
			transaction.commit();
			return true;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return true;
	}

	public List<Venues> getAllVenues(Venues venue) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			List<Venues> venueList = (List<Venues>) session.createQuery("from Venues", Venues.class).list();
			transaction.commit();
			return venueList;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return null;
	}

	public Venues getVenuesById(Long venueId) {
		Session session = null;
		Venues venue = null;
		try {
			session = factory.openSession();
			venue = session.get(Venues.class, venueId);
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return venue;
	}

	public List<Venues> getVenuesByName(String venueName) {
		List<Venues> venue = null;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Venues.class);
			criteria.add(Restrictions.eq("VenueName", venueName));
			transaction.commit();
			venue = criteria.list();
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return venue;
	}

	public List<Venues> getVenuesByLocation(String Location) {
		List<Venues> venue = null;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Venues.class);
			criteria.add(Restrictions.eq("Location", Location));
			transaction.commit();
			venue = criteria.list();
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return venue;
	}

	public boolean deleteVenueById(Long VenueID) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Venues venue = session.get(Venues.class, VenueID);
			session.delete(venue);
			transaction.commit();
			return true;
		} catch (Exception e) {
			EventsMessages.NotDeleteIdMessage();
		}
		return true;
	}

	public boolean deleteVenueByName(String venueName) {
		// List<Events> event = null;
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Venues.class);
			criteria.add(Restrictions.eq("VenueName", venueName));
			List<Venues> venue = criteria.list();
			for (Venues vnu : venue) {
				session.delete(vnu);
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

	public boolean deleteVenuesByLocation(String location) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Venues.class);
			criteria.add(Restrictions.eq("Location", location));
			List<Venues> venue = criteria.list();
			for (Venues vnu : venue) {
				session.delete(vnu);
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

	public List<Venues> deleteAllVenues() {
		List<Venues> venueList = new ArrayList<>();
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			venueList = session.createQuery("from Venues", Venues.class).list();
			for (Venues vnu : venueList) {
				session.delete(vnu);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			EventsMessages.errorMessage();
		}
		return venueList;
	}

	public String updateVenueById(Long VenueID, Venues updatedVenue) {
		Transaction transaction = null;
		Venues venue = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			venue = session.get(Venues.class, VenueID);
			if (venue != null) {
				venue.setVenueName(updatedVenue.getVenueName());
				venue.setLocation(updatedVenue.getLocation());
				venue.setCapacity(updatedVenue.getCapacity());
				session.update(venue);
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

	public String updateVenueByName(String VenueName, Venues updatedVenue) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Venues.class);
			criteria.add(Restrictions.eq("VenueName", VenueName));
			List<Venues> venue = criteria.list();
			if (venue != null && !venue.isEmpty()) {
				for (Venues vnu : venue) {
					vnu.setVenueName(updatedVenue.getVenueName());
					vnu.setLocation(updatedVenue.getLocation());
					vnu.setCapacity(updatedVenue.getCapacity());
					session.update(vnu);
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

}
