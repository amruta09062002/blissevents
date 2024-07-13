package com.example.BlissEvents.PhotographersEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.BlissEvents.EventsEntity.Events;

@Entity
public class Photographers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long photographerId;
	private String photographerName;
	private String contactInfo;
	
	@ManyToOne
	@JoinColumn(name="EventID")
	private Events event;

	
	
	public Photographers(String photographerName, String contactInfo, Events event) {
		this.photographerName = photographerName;
		this.contactInfo = contactInfo;
		this.event = event;
	}

	public long getPhotographerId() {
		return photographerId;
	}

	public void setPhotographerId(long photographerId) {
		this.photographerId = photographerId;
	}

	public String getPhotographerName() {
		return photographerName;
	}

	public void setPhotographerName(String photographerName) {
		this.photographerName = photographerName;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public Events getEvent() {
		return event;
	}

	public void setEvent(Events event) {
		this.event = event;
	}
	
	
}
