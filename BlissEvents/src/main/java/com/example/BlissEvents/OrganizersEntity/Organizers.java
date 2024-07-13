package com.example.BlissEvents.OrganizersEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Organizers {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long organizerId; 
	private String organizerName;
	private String phoneNumber;
	
	
	public Organizers() {
		
	}

	public Organizers( String organizerName, String phoneNumber) {
		this.organizerName = organizerName;
		this.phoneNumber = phoneNumber;
	}

	public long getOrganizerId() {
		return organizerId;
	}

	public void setOrganizerId(long organizerId) {
		this.organizerId = organizerId;
	}

	public String getOrganizerName() {
		return organizerName;
	}

	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
