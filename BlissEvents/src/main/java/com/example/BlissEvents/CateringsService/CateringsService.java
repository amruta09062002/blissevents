package com.example.BlissEvents.CateringsService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.AttendeesMessages.AttendeesMessages;
import com.example.BlissEvents.CateringsDao.CateringsDao;
import com.example.BlissEvents.CateringsEntity.Caterings;

@Service
public class CateringsService {
	
	@Autowired
	private CateringsDao dao;

	public String insertCatering(Caterings caterings) {
		if(dao.insertCatering(caterings)) {
			return AttendeesMessages.insertMessage();
		}else {
			return AttendeesMessages.notInsertMessage();
		}
	}

	public ArrayList<Caterings> getAllCaterings() {
		return dao.getAllCaterings();
	}

	public Caterings getCateringById(Long id) {
		return dao.getCateringById(id);

	}

	public List<Caterings> getCateringByName(String name) {
		return dao.getCateringByName(name);

	}

	public Caterings getCateringByPhoneNumber(String phone) {
		return dao.getCateringByPhoneNumber(phone);

	}

	public String deleteCateringById(Long id) {
		if(dao.deleteCateringById(id)) {
			return AttendeesMessages.deleteAttendee();
		}else {
			return AttendeesMessages.AttendeeNotDeleted();
		}
	}

	public String deleteCateringByName(String name) {
		if(dao.deleteCateringByName(name)) {
			return AttendeesMessages.deleteAttendee();
		}else {
			return AttendeesMessages.AttendeeNotDeleted();
		}
	}

	public String deleteCateringByphoneNumber(String phone) {
		if(dao.deleteCateringByphoneNumber(phone)) {
			return AttendeesMessages.deleteAttendee();
		}else {
			return AttendeesMessages.AttendeeNotDeleted();
		}
	}

	public String deleteAllCaterings() {
		if(dao.deleteAllCaterings()) {
			return AttendeesMessages.deleteAttendee();
		}else {
			return AttendeesMessages.AttendeeNotDeleted();
		}
	}

	public String updateCateringById(Long id, Caterings updatedCatering) {
		if(dao.updateCateringById(id,updatedCatering)) {
			return AttendeesMessages.updateAttendee();
		}else {
			return AttendeesMessages.AttendeeNotupdated();
		}	}

	public String updateCateringByName(String name, Caterings updatedCatering) {
		if(dao.updateCateringByName(name,updatedCatering)) {
			return AttendeesMessages.updateAttendee();
		}else {
			return AttendeesMessages.AttendeeNotupdated();
		}
	}

	public String updateCateringByphoneNumber(String phone, Caterings updatedCatering) {
		if(dao.updateCateringByphoneNumber(phone,updatedCatering)) {
			return AttendeesMessages.updateAttendee();
		}else {
			return AttendeesMessages.AttendeeNotupdated();
		}
	}

	public List<Caterings> getCateringsSortByName() {
		return dao.getCateringsSortByName();

	}

	
}
