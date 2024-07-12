package com.example.BlissEvents.PhotographerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.AttendeesMessages.AttendeesMessages;
import com.example.BlissEvents.PhotographerDao.PhotographerDao;
import com.example.BlissEvents.PhotographersEntity.Photographers;

@Service
public class PhotographerService {

	@Autowired
	private PhotographerDao dao;

	public String addPhotographer(Photographers photographer) {
		if(dao.addPhotographer(photographer)) {
			return AttendeesMessages.insertMessage();
		}else {
			return AttendeesMessages.notInsertMessage();
		}
	}

	public List<Photographers> getAllPhotographers() {
		return dao.getAllPhotographers();
	}

	public Photographers getPhotographerById(Long id) {
		return dao.getPhotographerById(id);
	}

	public List<Photographers> getPhotographerByName(String name) {
		return dao.getPhotographerByName(name);
	}

	public Photographers getPhotographerByPhoneNumber(String phone) {
		return dao.getPhotographerByPhoneNumber(phone);
	}

	public String deletePhotographerById(Long id) {
		if(dao.deletePhotographerById(id)) {
			return AttendeesMessages.deleteAttendee();
		}else {
			return AttendeesMessages.AttendeeNotDeleted();
		}
	}

	public String deletePhotographerByName(String name) {
		if(dao.deletePhotographerByName(name)) {
			return AttendeesMessages.deleteAttendee();
		}else {
			return AttendeesMessages.AttendeeNotDeleted();
		}
	}

	public String deletePhotographerByphoneNumber(String phone) {
		if(dao.deletePhotographerByphoneNumber(phone)) {
			return AttendeesMessages.deleteAttendee();
		}else {
			return AttendeesMessages.AttendeeNotDeleted();
		}
	}

	public String deleteAllPhotographers() {
		if(dao.deleteAllPhotographers()) {
			return AttendeesMessages.deleteAttendee();
		}else {
			return AttendeesMessages.AttendeeNotDeleted();
		}
	}

	public String updatePhotographerById(Long id, Photographers updatedPhotographer) {
		if(dao.updatePhotographerById(id,updatedPhotographer)) {
			return AttendeesMessages.updateAttendee();
		}else {
			return AttendeesMessages.AttendeeNotupdated();
		}
	}

	public String updatePhotographerByName(String name, Photographers updatedPhotographer) {
		if(dao.updatePhotographerByName(name,updatedPhotographer)) {
			return AttendeesMessages.updateAttendee();
		}else {
			return AttendeesMessages.AttendeeNotupdated();
		}
	}

	public String updatePhotographerByphoneNumber(String phone, Photographers updatedPhotographer) {
		if(dao.updatePhotographerByphoneNumber(phone,updatedPhotographer)) {
			return AttendeesMessages.updateAttendee();
		}else {
			return AttendeesMessages.AttendeeNotupdated();
		}	}

	public List<Photographers> getPhotographersSortByName() {
		return dao.getPhotographersSortByName();
	}
}
