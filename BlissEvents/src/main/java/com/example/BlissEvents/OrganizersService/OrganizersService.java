package com.example.BlissEvents.OrganizersService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.AttendeesDao.AttendeesDao;
import com.example.BlissEvents.AttendeesEntity.Attendees;
import com.example.BlissEvents.AttendeesMessages.AttendeesMessages;
import com.example.BlissEvents.OrganizersDao.OrganizersDao;
import com.example.BlissEvents.OrganizersEntity.Organizers;
import com.example.BlissEvents.OrganizersMessages.OrganizersMessages;

@Service
public class OrganizersService {
	
	@Autowired
	private OrganizersDao organizersDao;

	public String insertOrganizer(Organizers organizers) {
		if(organizersDao.insertOrganizer(organizers)) {
			return OrganizersMessages.insertMessage();
		}else {
			return OrganizersMessages.notInsertMessage();
		}
	}

	public List<Organizers> getAllOrganizers() {
		return organizersDao.getAllOrganizers();	}

	public Organizers getOrganizerById(int id) {
		return organizersDao.getOrganizerById(id);
	}

	public List<Organizers> getAttendeeByOrganizerName(String name) {
		return organizersDao.getAttendeeByOrganizerName(name);
	}

	public Organizers getOrganizerByphoneNumber(String phone) {
		return organizersDao.getOrganizerByphoneNumber(phone);
	}

	public String deleteOrganizerById(int id) {
		if(organizersDao.deleteOrganizerById(id)) {
			return OrganizersMessages.deleteOrganizer();
		}else {
			return OrganizersMessages.OrganizerNotDeleted();
		}
	}

	
	public String deleteOrganizerByName(String name) {
		if(organizersDao.deleteOrganizerByName(name)) {
			return OrganizersMessages.deleteOrganizer();
		}else {
			return OrganizersMessages.OrganizerNotDeleted();
		}
	}

	public String deleteOrganizerByphoneNumber(String phone) {
		if(organizersDao.deleteOrganizerByphoneNumber(phone)) {
			return OrganizersMessages.deleteOrganizer();
		}else {
			return OrganizersMessages.OrganizerNotDeleted();
		}
	}

	public String deleteAllOrganizers() {
		if(organizersDao.deleteAllOrganizers()) {
			return OrganizersMessages.deleteOrganizer();
		}else {
			return OrganizersMessages.OrganizerNotDeleted();
		}
	}

	public String updateOrganizerById(int id, Organizers updatedOrganizer) {
		if(organizersDao.updateOrganizerById(id,updatedOrganizer)) {
			return OrganizersMessages.updateOrganizer();
		}else {
			return OrganizersMessages.OrganizerNotupdated();
		}
	}

	public String updateOrganizerByName(String name, Organizers updatedOrganizer) {
		if(organizersDao.updateOrganizerByName(name,updatedOrganizer)) {
			return OrganizersMessages.updateOrganizer();
		}else {
			return OrganizersMessages.OrganizerNotupdated();
		}
	}

	public String updateOrganizerByphoneNumber(String phone, Organizers updatedOrganizer) {
		if(organizersDao.updateOrganizerByphoneNumber(phone,updatedOrganizer)) {
			return OrganizersMessages.updateOrganizer();
		}else {
			return OrganizersMessages.OrganizerNotupdated();
		}
	}

	public List<Organizers> sortedByOrganizerName() {
		return organizersDao.sortedByOrganizerName();
	}



}
