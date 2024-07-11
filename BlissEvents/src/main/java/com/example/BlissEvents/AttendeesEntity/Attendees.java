package com.example.BlissEvents.AttendeesEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Attendees {
    
    private long attendeeID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    
    public Attendees() {
        
    }
    
    public Attendees(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getAttendeeID() {
        return attendeeID;
    }
    public void setAttendeeID(long attendeeID) {
        this.attendeeID = attendeeID;
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
}
