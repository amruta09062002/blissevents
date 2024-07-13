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
	private Long EventID;
	private String EventName;
	private LocalDate EventDate;
	
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
		EventName = eventName;
		EventDate = eventDate;
		this.organizer = organizer;
		this.venue = venue;
	}

	public Organizers getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizers organizer) {
		this.organizer = organizer;
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

}
