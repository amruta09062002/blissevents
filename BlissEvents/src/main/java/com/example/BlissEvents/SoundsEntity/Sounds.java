package com.example.BlissEvents.SoundsEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.BlissEvents.EventsEntity.Events;

@Entity
public class Sounds {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long soundId;
	private String soundType;
	private String soundBrand;
	private int soundQuantity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EventID")
	private Events events;

	public Sounds() {
		
	}

	public Sounds(String soundType, String soundBrand, int soundQuantity, Events events) {
		super();
		this.soundType = soundType;
		this.soundBrand = soundBrand;
		this.soundQuantity = soundQuantity;
		this.events = events;
	}

	public long getSoundId() {
		return soundId;
	}

	public void setSoundId(long soundId) {
		this.soundId = soundId;
	}

	public String getSoundType() {
		return soundType;
	}

	public void setSoundType(String soundType) {
		this.soundType = soundType;
	}

	public String getSoundBrand() {
		return soundBrand;
	}

	public void setSoundBrand(String soundBrand) {
		this.soundBrand = soundBrand;
	}

	public int getSoundQuantity() {
		return soundQuantity;
	}

	public void setSoundQuantity(int soundQuantity) {
		this.soundQuantity = soundQuantity;
	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

}
