package com.example.BlissEvents.AttendeesEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.BlissEvents.EventsEntity.Events;

@Entity
public class Attendees {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long attendeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EventID")
    private Events event;
    
    public Attendees() {
        
    }

	public Attendees(String firstName, String lastName, String email, String phoneNumber, Events event) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.event = event;
	}

	public long getAttendeeId() {
		return attendeeId;
	}

	public void setAttendeeId(long attendeeId) {
		this.attendeeId = attendeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
