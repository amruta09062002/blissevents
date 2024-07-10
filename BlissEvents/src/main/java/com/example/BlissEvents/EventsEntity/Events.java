package com.example.BlissEvents.EventsEntity;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.BlissEvents.VenuesEntity.Venues;

@Entity
public class Events {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long EventID;
	private String EventName;
	private LocalDate EventDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "VenueID")
	private Venues venue;
	
	private Long OrganizerID;
	
	public Events() {
		
	}

	public Events(Long eventId, String eventName, LocalDate eventDate, Venues venue, Long organizerID) {
		EventID = eventId;
		EventName = eventName;
		EventDate = eventDate;
		this.venue = venue;
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

	public Venues getVenue() {
		return venue;
	}

	public void setVenue(Venues venue) {
		this.venue = venue;
	}

	public Long getOrganizerID() {
		return OrganizerID;
	}

	public void setOrganizerID(Long organizerID) {
		OrganizerID = organizerID;
	}


}
