package com.example.BlissEvents.UsersEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.BlissEvents.EventsEntity.Events;
import com.example.BlissEvents.OrganizersEntity.Organizers;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long UserId;
	private String UserName;
	private String Password;
	private String email;
	private String FirstName;
	private String LastName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name  = "EventID")
	Events event;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "organizerID")
	Organizers organizer;
	
	public Users() {
		
	}

	public Users(long userId, String userName, String password, String email, String firstName, String lastName,
			Events event, Organizers organizer) {
		UserId = userId;
		UserName = userName;
		Password = password;
		this.email = email;
		FirstName = firstName;
		LastName = lastName;
		this.event = event;
		this.organizer = organizer;
	}

	public long getUserId() {
		return UserId;
	}

	public void setUserId(long userId) {
		UserId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Events getEvent() {
		return event;
	}

	public void setEvent(Events event) {
		this.event = event;
	}

	public Organizers getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizers organizer) {
		this.organizer = organizer;
	}
	
	
	
}
