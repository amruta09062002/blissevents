package com.example.BlissEvents.OrganizersEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Organizers {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int organizerID; 
	private String organizerName;
	private String phoneNumber;
	
	
	public Organizers() {
		
	}

	public Organizers(int organizerID, String organizerName, String phoneNumber) {
		this.organizerID = organizerID;
		this.organizerName = organizerName;
		this.phoneNumber = phoneNumber;
	}

	public int getOrganizerID() {
		return organizerID;
	}

	public void setOrganizerID(int organizerID) {
		this.organizerID = organizerID;
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
