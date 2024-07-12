package com.example.BlissEvents.DecorationsEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.example.BlissEvents.EventsEntity.Events;

@Entity
public class Decorations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long decorationId;
	private String decorationType;
	private String decorationBrand;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_id")
	private Events events;

	public Decorations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Decorations(String decorationType, String decorationBrand, Events events) {
		super();
		this.decorationType = decorationType;
		this.decorationBrand = decorationBrand;
		this.events = events;
	}

	public long getDecorationId() {
		return decorationId;
	}

	public void setDecorationId(long decorationId) {
		this.decorationId = decorationId;
	}

	public String getDecorationType() {
		return decorationType;
	}

	public void setDecorationType(String decorationType) {
		this.decorationType = decorationType;
	}

	public String getDecorationBrand() {
		return decorationBrand;
	}

	public void setDecorationBrand(String decorationBrand) {
		this.decorationBrand = decorationBrand;
	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

}
