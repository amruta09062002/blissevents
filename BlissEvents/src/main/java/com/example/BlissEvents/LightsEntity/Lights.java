package com.example.BlissEvents.LightsEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.BlissEvents.EventsEntity.Events;

@Entity
public class Lights {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long lightId;
	private String lightType;
	private String lightBrand;
	private int lightQuantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EventID")
	Events event;
	
	public Lights() {
		
	}

	public Lights(String lightType, String lightBrand, int lightQuantity, Events event) {
		this.lightType = lightType;
		this.lightBrand = lightBrand;
		this.lightQuantity = lightQuantity;
		this.event = event;
	}

	public long getLightId() {
		return lightId;
	}

	public void setLightId(long lightId) {
		this.lightId = lightId;
	}

	public String getLightType() {
		return lightType;
	}

	public void setLightType(String lightType) {
		this.lightType = lightType;
	}

	public String getLightBrand() {
		return lightBrand;
	}

	public void setLightBrand(String lightBrand) {
		this.lightBrand = lightBrand;
	}

	public int getLightQuantity() {
		return lightQuantity;
	}

	public void setLightQuantity(int lightQuantity) {
		this.lightQuantity = lightQuantity;
	}

	public Events getEvent() {
		return event;
	}

	public void setEvent(Events event) {
		this.event = event;
	}


	
}
