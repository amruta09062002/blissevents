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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long soundId;
	private String soundType;
	private String soundBrand;
	private int soundQuantity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EventId")
	private Events event;

	public Sounds() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sounds(String soundType, String soundBrand, int soundQuantity, Events event) {
		super();
		this.soundType = soundType;
		this.soundBrand = soundBrand;
		this.soundQuantity = soundQuantity;
		this.event = event;
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
		return event;
	}

	public void setEvents(Events event) {
		this.event = event;
	}

}
