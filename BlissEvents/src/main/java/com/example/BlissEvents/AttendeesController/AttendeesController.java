package com.example.BlissEvents.AttendeesController;

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

import com.example.BlissEvents.AttendeesEntity.Attendees;
import com.example.BlissEvents.AttendeesService.AttendeesService;

@RestController
@RequestMapping("api/attendees")
public class AttendeesController {

	@Autowired
	AttendeesService attendeesService;

	@PostMapping("/insert-attendee")
	public String insertAttendee(@RequestBody Attendees attendees) {
		return attendeesService.insertAttendee(attendees);
	}

	@GetMapping("/get-all-attendees")
	public List<Attendees> getAllAttendees() {
		return attendeesService.getAllAttendees();
	}

	@GetMapping("/get-attendee-by-id/{attendeeID}")
	public Attendees getAttendeeById(@PathVariable("attendeeID") Long id) {
		return attendeesService.getAttendeeById(id);
	}

	@GetMapping("/get-attendee-by-firstname/{firstName}")
	public List<Attendees> getAttendeeByFirstName(@PathVariable("firstName") String fname) {
		return attendeesService.getAttendeeByFirstName(fname);
	}

	@GetMapping("/get-attendee-by-lastname/{lastName}")
	public List<Attendees> getAttendeeByLastName(@PathVariable("lastName") String lname) {
		return attendeesService.getAttendeeByLastName(lname);
	}

	@GetMapping("/get-attendee-by-phonenumber/{phoneNumber}")
	public Attendees getAttendeeByPhoneNumber(@PathVariable("phoneNumber") String Phone) {
		return attendeesService.getAttendeeByPhoneNumber(Phone);
	}

	@DeleteMapping("/delete-attendee-by-id/{attendeeID}")
	public String deleteAttendeeById(@PathVariable("attendeeID") Long id) {
		return attendeesService.deleteAttendeeById(id);
	}

	@DeleteMapping("/delete-attendee-by-firstname/{firstName}")
	public String deleteAttendeeByFirstName(@PathVariable("firstName") String fname) {
		return attendeesService.deleteAttendeeByFirstName(fname);
	}

	@DeleteMapping("/delete-attendee-by-lastname/{lastName}")
	public String deleteAttendeeByLastName(@PathVariable("lastName") String lname) {
		return attendeesService.deleteAttendeeByLastName(lname);
	}

	@DeleteMapping("/delete-attendee-by-phonenumber/{phoneNumber}")
	public String deleteAttendeeByphoneNumber(@PathVariable("phoneNumber") String phone) {
		return attendeesService.deleteAttendeeByphoneNumber(phone);
	}

	@DeleteMapping("/delete-all-attendees")
	public String deleteAllAttendees() {
		return attendeesService.deleteAllAttendees();
	}

	@PutMapping("/update-attendee-by-id/{attendeeID}")
	public String updateAttendeeById(@PathVariable("attendeeID") Long id, @RequestBody Attendees updatedAttendee) {
		return attendeesService.updateAttendeeById(id, updatedAttendee);
	}
	
	@PutMapping("/update-attendee-by-firstname/{firstName}")
	public String updateAttendeeByFirstName(@PathVariable("firstName") String name, @RequestBody Attendees updatedAttendee) {
		return attendeesService.updateAttendeeByFirstName(name, updatedAttendee);
	}
	
	@PutMapping("/update-attendee-by-lastname/{lastName}")
	public String updateAttendeeByLastName(@PathVariable("lastName") String lname, @RequestBody Attendees updatedAttendee) {
		return attendeesService.updateAttendeeByLastName(lname, updatedAttendee);
	}
	
	@PutMapping("/update-attendee-by-phonenumber/{phoneNumber}")
	public String updateAttendeeByphoneNumber(@PathVariable("phoneNumber") String phone, @RequestBody Attendees updatedAttendee) {
		return attendeesService.updateAttendeeByphoneNumber(phone, updatedAttendee);
	}
	
	@GetMapping("/sorted-by-firstname")
    public List<Attendees> getAttendeesSortedByFirstName() {
        return attendeesService.getAttendeesSortedByFirstName();
    }
	
}
