package com.example.BlissEvents.AttendeesService;

import com.example.BlissEvents.AttendeesDao.AttendeesDao;
import com.example.BlissEvents.AttendeesEntity.Attendees;
import com.example.BlissEvents.AttendeesMessages.AttendeesMessages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeesService {

	@Autowired
	private AttendeesDao attendeesDao;

	public String insertAttendee(Attendees attendee) {
		if(attendeesDao.insertAttendee(attendee)) {
			return AttendeesMessages.insertMessage();
		}else {
			return AttendeesMessages.notInsertMessage();
		}
	}
	
	public List<Attendees> getAllAttendees() {
		return attendeesDao.getAllAttendees();
	}

	

	public Attendees getAttendeeById(Long id) {
		return attendeesDao.getAttendeeById(id);

	}

	public List<Attendees> getAttendeeByFirstName(String fname) {
		return attendeesDao.getAttendeeByFirstName(fname);
	}

	public List<Attendees> getAttendeeByLastName(String lname) {
		return attendeesDao.getAttendeeByLastName(lname);
	}

	public Attendees getAttendeeByPhoneNumber(String phone) {
		return attendeesDao.getAttendeeByPhoneNumber(phone);
	}

	public String deleteAttendeeById(Long id) {
		if(attendeesDao.deleteAttendeeById(id)) {
			return AttendeesMessages.deleteAttendee();
		}else {
			return AttendeesMessages.AttendeeNotDeleted();
		}
	}

	public String deleteAttendeeByFirstName(String fname) {
		if(attendeesDao.deleteAttendeeByFirstName(fname)) {
			return AttendeesMessages.deleteAttendee();
		}else {
			return AttendeesMessages.AttendeeNotDeleted();
		}
	}

	public String deleteAttendeeByLastName(String lname) {
		if(attendeesDao.deleteAttendeeByLastName(lname)) {
			return AttendeesMessages.deleteAttendee();
		}else {
			return AttendeesMessages.AttendeeNotDeleted();
		}
	}

	public String deleteAttendeeByphoneNumber(String phone) {
		if(attendeesDao.deleteAttendeeByphoneNumber(phone)) {
			return AttendeesMessages.deleteAttendee();
		}else {
			return AttendeesMessages.AttendeeNotDeleted();
		}
	}

	public String deleteAllAttendees() {
		if(attendeesDao.deleteAllAttendees()) {
			return AttendeesMessages.deleteAttendee();
		}else {
			return AttendeesMessages.AttendeeNotDeleted();
		}
	}

	public String updateAttendeeById(Long id, Attendees updatedAttendee) {
		if(attendeesDao.updateAttendeeById(id,updatedAttendee)) {
			return AttendeesMessages.updateAttendee();
		}else {
			return AttendeesMessages.AttendeeNotupdated();
		}
			
	}

	public String updateAttendeeByFirstName(String name, Attendees updatedAttendee) {
		if(attendeesDao.updateAttendeeByFirstName(name,updatedAttendee)) {
			return AttendeesMessages.updateAttendee();
		}else {
			return AttendeesMessages.AttendeeNotupdated();
		}
	}

	public String updateAttendeeByLastName(String lname, Attendees updatedAttendee) {
		if(attendeesDao.updateAttendeeByLastName(lname,updatedAttendee)) {
			return AttendeesMessages.updateAttendee();
		}else {
			return AttendeesMessages.AttendeeNotupdated();
		}
	}

	public String updateAttendeeByphoneNumber(String phone, Attendees updatedAttendee) {
		if(attendeesDao.updateAttendeeByphoneNumber(phone,updatedAttendee)) {
			return AttendeesMessages.updateAttendee();
		}else {
			return AttendeesMessages.AttendeeNotupdated();
		}
	}

	public List<Attendees> getAttendeesSortedByFirstName() {
		return attendeesDao.getAttendeesSortedByFirstName();
	}

}
