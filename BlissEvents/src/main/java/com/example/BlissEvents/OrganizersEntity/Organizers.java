package com.example.BlissEvents.OrganizersEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.BlissEvents.EventsEntity.Events;

@Entity
public class Organizers {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int organizerID; 
	private String organizerName;
	private String phoneNumber;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EventID")
    private Events event;
	
	public Organizers() {
		
	}

	public Organizers(int organizerID, String organizerName, String phoneNumber, Events event) {
		super();
		this.organizerID = organizerID;
		this.organizerName = organizerName;
		this.phoneNumber = phoneNumber;
		this.event = event;
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

	public Events getEvent() {
		return event;
	}

	public void setEvent(Events event) {
		this.event = event;
	}

}
