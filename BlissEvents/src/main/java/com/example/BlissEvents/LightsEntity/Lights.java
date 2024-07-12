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
	private long LightId;
	private String LightType;
	private String LightBrand;
	private int LightQuantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EventID")
	Events event;
	
	public Lights() {
		
	}

	public Lights(long lightId, String lightType, String lightBrand, int lightQuantity, Events event) {
		super();
		LightId = lightId;
		LightType = lightType;
		LightBrand = lightBrand;
		LightQuantity = lightQuantity;
		this.event = event;
	}

	public long getLightId() {
		return LightId;
	}

	public void setLightId(long lightId) {
		LightId = lightId;
	}

	public String getLightType() {
		return LightType;
	}

	public void setLightType(String lightType) {
		LightType = lightType;
	}

	public String getLightBrand() {
		return LightBrand;
	}

	public void setLightBrand(String lightBrand) {
		LightBrand = lightBrand;
	}

	public int getLightQuantity() {
		return LightQuantity;
	}

	public void setLightQuantity(int lightQuantity) {
		LightQuantity = lightQuantity;
	}

	public Events getEvent() {
		return event;
	}

	public void setEvent(Events event) {
		this.event = event;
	}
	
	
	
}
