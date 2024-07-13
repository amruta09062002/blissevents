package com.example.BlissEvents.CateringsEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.BlissEvents.EventsEntity.Events;

@Entity
public class Caterings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cateringID;
	private String cateringName;
	private String cateringMenu;
	private String contactInfo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="eventId")
	private Events event;

	
	public Caterings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Caterings(String cateringName, String cateringMenu, String contactInfo, Events event) {
		super();
		this.cateringName = cateringName;
		this.cateringMenu = cateringMenu;
		this.contactInfo = contactInfo;
		this.event = event;
	}

	public long getCateringID() {
		return cateringID;
	}

	public void setCateringID(long cateringID) {
		this.cateringID = cateringID;
	}

	public String getCateringName() {
		return cateringName;
	}

	public void setCateringName(String cateringName) {
		this.cateringName = cateringName;
	}

	public String getCateringMenu() {
		return cateringMenu;
	}

	public void setCateringMenu(String cateringMenu) {
		this.cateringMenu = cateringMenu;
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
