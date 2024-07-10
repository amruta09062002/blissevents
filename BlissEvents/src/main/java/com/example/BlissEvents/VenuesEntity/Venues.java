package com.example.BlissEvents.VenuesEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Venues {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long VenueID;
	private String VenueName;
	private String Location;
	private int Capacity;
	
	public Venues() {
		
	}
	
	public Venues(Long venueID, String venueName, String location, int capacity) {
		VenueID = venueID;
		VenueName = venueName;
		Location = location;
		Capacity = capacity;
	}

	public Long getVenueID() {
		return VenueID;
	}

	public void setVenueID(Long venueID) {
		VenueID = venueID;
	}

	public String getVenueName() {
		return VenueName;
	}

	public void setVenueName(String venueName) {
		VenueName = venueName;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}

	@Override
	public String toString() {
		return "Venues [VenueID=" + VenueID + ", VenueName=" + VenueName + ", Location=" + Location + ", Capacity="
				+ Capacity + "]";
	}
	
}
