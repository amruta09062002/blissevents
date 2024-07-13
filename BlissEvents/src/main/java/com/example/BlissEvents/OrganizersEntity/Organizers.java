package com.example.BlissEvents.OrganizersEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Organizers {
<<<<<<< HEAD
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int organizerID; 
=======
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int organizerId; 
>>>>>>> refs/remotes/origin/Akash
	private String organizerName;
	private String phoneNumber;
	
	
	public Organizers() {
		
	}

	public Organizers(int organizerID, String organizerName, String phoneNumber) {
		this.organizerID = organizerID;
		this.organizerName = organizerName;
		this.phoneNumber = phoneNumber;
	}
<<<<<<< HEAD

	public int getOrganizerID() {
		return organizerID;
=======
	
	
	public int getOrganizerId() {
		return organizerId;
>>>>>>> refs/remotes/origin/Akash
	}
<<<<<<< HEAD

	public void setOrganizerID(int organizerID) {
		this.organizerID = organizerID;
=======
	public void setOrganizerId(int organizerId) {
		this.organizerId = organizerId;
>>>>>>> refs/remotes/origin/Akash
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
