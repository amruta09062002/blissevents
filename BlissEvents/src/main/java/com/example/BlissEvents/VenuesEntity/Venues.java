package com.example.BlissEvents.VenuesEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Venues {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long venueID;
	private String venueName;
	private String location;
	private int capacity;
	
	public Venues() {
		
	}
	
	public Venues(String venueName, String location, int capacity) {
		this.venueName = venueName;
		this.location = location;
		this.capacity = capacity;
	}

<<<<<<< HEAD
	public Long getVenueID() {
		return venueID;
=======
	public Long getVenueId() {
		return venueId;
>>>>>>> refs/remotes/origin/Akash
	}

<<<<<<< HEAD
	public void setVenueID(Long venueID) {
		this.venueID = venueID;
=======
	public void setVenueId(Long venueId) {
		this.venueId = venueId;
>>>>>>> refs/remotes/origin/Akash
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
<<<<<<< HEAD


=======
	
>>>>>>> refs/remotes/origin/Akash
	
}
