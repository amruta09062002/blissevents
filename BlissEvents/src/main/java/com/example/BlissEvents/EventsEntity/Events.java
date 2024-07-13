package com.example.BlissEvents.EventsEntity;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.BlissEvents.OrganizersEntity.Organizers;
import com.example.BlissEvents.VenuesEntity.Venues;

@Entity
public class Events {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventId;
	private String eventName;
	private LocalDate eventDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "venueId")
	private Venues venue;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OrganizerId")
	private Organizers organizers;
	
	public Events() {
		
	}

	public Events(String eventName, LocalDate eventDate, Venues venue, Organizers organizers) {
		super();
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.venue = venue;
		this.organizers = organizers;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public Venues getVenue() {
		return venue;
	}

	public void setVenue(Venues venue) {
		this.venue = venue;
	}

	public Organizers getOrganizers() {
		return organizers;
	}

	public void setOrganizers(Organizers organizers) {
		this.organizers = organizers;
	}

	
	

}
