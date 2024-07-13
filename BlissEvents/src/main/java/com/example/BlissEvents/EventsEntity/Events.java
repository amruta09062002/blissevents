package com.example.BlissEvents.EventsEntity;


import java.time.LocalDate;

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
	private Long eventID;
	private String eventName;
	private LocalDate eventDate;
	
	@ManyToOne
    @JoinColumn(name = "organizer_id", referencedColumnName = "organizerId")
    private Organizers organizer;
    
    @ManyToOne
    @JoinColumn(name = "venue_id", referencedColumnName = "venueId")
    private Venues venue;
	
	public Events() {
		
	}

	public Events(String eventName, LocalDate eventDate, Organizers organizer, Venues venue) {
		super();
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.organizer = organizer;
		this.venue = venue;
	}

	public Long getEventID() {
		return eventID;
	}

	public void setEventID(Long eventID) {
		this.eventID = eventID;
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

	public Organizers getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizers organizer) {
		this.organizer = organizer;
	}

	public Venues getVenue() {
		return venue;
	}

	public void setVenue(Venues venue) {
		this.venue = venue;
	}

}
