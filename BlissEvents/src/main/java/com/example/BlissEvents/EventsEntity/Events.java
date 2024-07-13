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
<<<<<<< HEAD
	private Long eventID;
=======
	private Long eventId;
>>>>>>> refs/remotes/origin/Akash
	private String eventName;
	private LocalDate eventDate;
	
<<<<<<< HEAD
	@ManyToOne
    @JoinColumn(name = "organizer_id", referencedColumnName = "organizerId")
    private Organizers organizer;
    
    @ManyToOne
    @JoinColumn(name = "venue_id", referencedColumnName = "venueId")
    private Venues venue;
=======
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "venueId")
	private Venues venue;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OrganizerId")
	private Organizers organizers;
>>>>>>> refs/remotes/origin/Akash
	
	public Events() {
		
	}

<<<<<<< HEAD
	public Events(String eventName, LocalDate eventDate, Organizers organizer, Venues venue) {
		super();
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.organizer = organizer;
=======
	public Events(String eventName, LocalDate eventDate, Venues venue, Organizers organizers) {
		super();
		this.eventName = eventName;
		this.eventDate = eventDate;
>>>>>>> refs/remotes/origin/Akash
		this.venue = venue;
<<<<<<< HEAD
=======
		this.organizers = organizers;
>>>>>>> refs/remotes/origin/Akash
	}

<<<<<<< HEAD
	public Long getEventID() {
		return eventID;
=======
	public Long getEventId() {
		return eventId;
>>>>>>> refs/remotes/origin/Akash
	}

<<<<<<< HEAD
	public void setEventID(Long eventID) {
		this.eventID = eventID;
=======
	public void setEventId(Long eventId) {
		this.eventId = eventId;
>>>>>>> refs/remotes/origin/Akash
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
<<<<<<< HEAD
	}

	public Organizers getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizers organizer) {
		this.organizer = organizer;
=======
>>>>>>> refs/remotes/origin/Akash
	}

	public Venues getVenue() {
		return venue;
	}

	public void setVenue(Venues venue) {
		this.venue = venue;
	}

<<<<<<< HEAD
=======
	public Organizers getOrganizers() {
		return organizers;
	}

	public void setOrganizers(Organizers organizers) {
		this.organizers = organizers;
	}

	
	

>>>>>>> refs/remotes/origin/Akash
}
