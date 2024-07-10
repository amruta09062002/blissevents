package com.example.BlissEvents.VenuesService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.EventsEntity.Events;
import com.example.BlissEvents.EventsMessages.EventsMessages;
import com.example.BlissEvents.VenuesDao.VenuesDao;
import com.example.BlissEvents.VenuesEntity.Venues;

@Service
public class VenuesService {

	@Autowired
	VenuesDao venueDao;

	public String insertVenues(Venues venue) {
		if (venueDao.insertVenues(venue)) {
			return EventsMessages.insertMessage();
		} else {
			return EventsMessages.notInsertMessage();
		}
	}

	public List<Venues> getAllVenues(Venues venue) {
		return venueDao.getAllVenues(venue);
	}

	public Venues getVenuesById(Long venueId) {
		if (venueDao.getVenuesById(venueId) != null) {
			return venueDao.getVenuesById(venueId);
		} else {
			EventsMessages.EventNotFound();
		}
		return null;
	}

	public List<Venues> getVenuesByName(String venueName) {
		if (venueDao.getVenuesByName(venueName) != null) {
			return venueDao.getVenuesByName(venueName);
		} else {
			EventsMessages.EventNotFound();
		}
		return null;
	}

	public List<Venues> getVenuesByLocation(String Location) {
		if (venueDao.getVenuesByLocation(Location) != null) {
			return venueDao.getVenuesByLocation(Location);
		} else {
			EventsMessages.EventNotFound();
		}
		return null;
	}

	public String deleteVenueById(Long VenueID) {
		if (venueDao.deleteVenueById(VenueID)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}

	}

	public String deleteVenueByName(String venueName) {
		if (venueDao.deleteVenueByName(venueName)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

	public String deleteVenuesByLocation(String location) {
		if (venueDao.deleteVenuesByLocation(location)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

	public String deleteAllVenues() {
		if (venueDao.deleteAllVenues() != null) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

	public String updateVenueById(Long VenueID, Venues updatedVenue) {
		if (venueDao.updateVenueById(VenueID, updatedVenue) != null) {
			return EventsMessages.updatedMessage();
		} else {
			return EventsMessages.notUpdatedMessage();
		}
	}

	public String updateVenueByName(String VenueName, Venues updatedVenue) {
		if (venueDao.updateVenueByName(VenueName, updatedVenue) != null) {
			return EventsMessages.updatedMessage();
		} else {
			return EventsMessages.notUpdatedMessage();
		}
	}

}
