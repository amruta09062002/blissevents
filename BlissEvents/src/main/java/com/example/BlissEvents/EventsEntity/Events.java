package com.example.BlissEvents.EventsEntity;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Events {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long EventID;
	private String EventName;
	private LocalDate EventDate;
	private Long VenueID;
	private Long OrganizerID;
	
	public Events() {
		
	}

	public Events(Long eventId, String eventName, LocalDate eventDate, Long venueID, Long organizerID) {
		EventID = eventId;
		EventName = eventName;
		EventDate = eventDate;
		VenueID = venueID;
		OrganizerID = organizerID;
	}

	public Long getEventID() {
		return EventID;
	}

	public void setEventID(Long eventID) {
		EventID = eventID;
	}

	public String getEventName() {
		return EventName;
	}

	public void setEventName(String eventName) {
		EventName = eventName;
	}

	public LocalDate getEventDate() {
		return EventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		EventDate = eventDate;
	}

	public Long getVenueID() {
		return VenueID;
	}

	public void setVenueID(Long venueID) {
		VenueID = venueID;
	}

	public Long getOrganizerID() {
		return OrganizerID;
	}

	public void setOrganizerID(Long organizerID) {
		OrganizerID = organizerID;
	}


}
