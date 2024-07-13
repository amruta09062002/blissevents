package com.example.BlissEvents.OrganizersController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlissEvents.OrganizersEntity.Organizers;
import com.example.BlissEvents.OrganizersService.OrganizersService;

@RestController
@RequestMapping("api/organizer")
public class OrganizersController {


	@Autowired
	OrganizersService organizersService;

	@PostMapping("/insertOrganizer")
	public String insertOrganizer(@RequestBody Organizers organizers) {
		return organizersService.insertOrganizer(organizers);
	}

	@GetMapping("/get-all-organizers")
	public List<Organizers> getAllOrganizers() {
		return organizersService.getAllOrganizers();
	}

	@GetMapping("/getOrganizerById/{organizerID}")
	public Organizers getOrganizerById(@PathVariable("organizerID") int id) {
		return organizersService.getOrganizerById(id);
	}

	@GetMapping("/getAttendeeByOrganizerName/{organizerName}")
	public List<Organizers> getAttendeeByOrganizerName(@PathVariable("organizerName") String name) {
		return organizersService.getAttendeeByOrganizerName(name);
	}

	@GetMapping("/getOrganizerByphoneNumber/{phoneNumber}")
	public Organizers getOrganizerByphoneNumber(@PathVariable("phoneNumber") String Phone) {
		return organizersService.getOrganizerByphoneNumber(Phone);
	}

	@DeleteMapping("/deleteOrganizerById/{organizerID}")
	public String deleteOrganizerById(@PathVariable("organizerID") int id) {
		return organizersService.deleteOrganizerById(id);
	}

	@DeleteMapping("/deleteOrganizerByName/{organizerName}")
	public String deleteOrganizerByName(@PathVariable("organizerName") String name) {
		return organizersService.deleteOrganizerByName(name);
	}

	@DeleteMapping("/deleteOrganizerByphoneNumber/{phoneNumber}")
	public String deleteOrganizerByphoneNumber(@PathVariable("phoneNumber") String phone) {
		return organizersService.deleteOrganizerByphoneNumber(phone);
	}

	@DeleteMapping("/deleteAllOrganizers")
	public String deleteAllOrganizers() {
		return organizersService.deleteAllOrganizers();
	}

	@PutMapping("/updateOrganizerById/{organizerID}")
	public String updateOrganizerById(@PathVariable("organizerID") int id, @RequestBody Organizers updatedOrganizer) {
		return organizersService.updateOrganizerById(id, updatedOrganizer);
	}
	
	@PutMapping("/updateOrganizerByName/{organizerName}")
	public String updateOrganizerByName(@PathVariable("organizerName") String name, @RequestBody Organizers updatedOrganizer) {
		return organizersService.updateOrganizerByName(name, updatedOrganizer);
	}
	
	@PutMapping("/updateOrganizerByphoneNumber/{phoneNumber}")
	public String updateOrganizerByphoneNumber(@PathVariable("phoneNumber") String phone, @RequestBody Organizers updatedOrganizer) {
		return organizersService.updateOrganizerByphoneNumber(phone, updatedOrganizer);
	}
	
	@GetMapping("/sortedByOrganizerName")
    public List<Organizers> sortedByOrganizerName() {
        return organizersService.sortedByOrganizerName();
    }
	


}
