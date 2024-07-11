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

	@PostMapping("/insertAttendee")
	public String insertAttendee(@RequestBody Attendees attendees) {
		return attendeesService.insertAttendee(attendees);
	}

	@GetMapping
	public List<Attendees> getAllAttendees() {
		return attendeesService.getAllAttendees();
	}

	@GetMapping("/getAttendeeById/{attendeeID}")
	public Attendees getAttendeeById(@PathVariable("attendeeID") Long id) {
		return attendeesService.getAttendeeById(id);
	}

	@GetMapping("/getAttendeeByFirstName/{firstName}")
	public List<Attendees> getAttendeeByFirstName(@PathVariable("firstName") String fname) {
		return attendeesService.getAttendeeByFirstName(fname);
	}

	@GetMapping("/getAttendeeByLastName/{lastName}")
	public List<Attendees> getAttendeeByLastName(@PathVariable("lastName") String lname) {
		return attendeesService.getAttendeeByLastName(lname);
	}

	@GetMapping("/getAttendeeByphoneNumber/{phoneNumber}")
	public Attendees getAttendeeByPhoneNumber(@PathVariable("phoneNumber") String Phone) {
		return attendeesService.getAttendeeByPhoneNumber(Phone);
	}

	@DeleteMapping("/deleteAttendeeById/{attendeeID}")
	public String deleteAttendeeById(@PathVariable("attendeeID") Long id) {
		return attendeesService.deleteAttendeeById(id);
	}

	@DeleteMapping("/deleteAttendeeByFirstName/{firstName}")
	public String deleteAttendeeByFirstName(@PathVariable("firstName") String fname) {
		return attendeesService.deleteAttendeeByFirstName(fname);
	}

	@DeleteMapping("/deleteAttendeeByLastName/{lastName}")
	public String deleteAttendeeByLastName(@PathVariable("lastName") String lname) {
		return attendeesService.deleteAttendeeByLastName(lname);
	}

	@DeleteMapping("/deleteAttendeeByphoneNumber/{phoneNumber}")
	public String deleteAttendeeByphoneNumber(@PathVariable("phoneNumber") String phone) {
		return attendeesService.deleteAttendeeByphoneNumber(phone);
	}

	@DeleteMapping("/deleteAllAttendees")
	public String deleteAllAttendees() {
		return attendeesService.deleteAllAttendees();
	}

	@PutMapping("/updateAttendeeById/{attendeeID}")
	public String updateAttendeeById(@PathVariable("attendeeID") Long id, @RequestBody Attendees updatedAttendee) {
		return attendeesService.updateAttendeeById(id, updatedAttendee);
	}
	
	@PutMapping("/updateAttendeeByFirstName/{firstName}")
	public String updateAttendeeByFirstName(@PathVariable("firstName") String name, @RequestBody Attendees updatedAttendee) {
		return attendeesService.updateAttendeeByFirstName(name, updatedAttendee);
	}
	
	@PutMapping("/updateAttendeeByLastName/{lastName}")
	public String updateAttendeeByLastName(@PathVariable("lastName") String lname, @RequestBody Attendees updatedAttendee) {
		return attendeesService.updateAttendeeByLastName(lname, updatedAttendee);
	}
	
	@PutMapping("/updateAttendeeByphoneNumber/{phoneNumber}")
	public String updateAttendeeByphoneNumber(@PathVariable("phoneNumber") String phone, @RequestBody Attendees updatedAttendee) {
		return attendeesService.updateAttendeeByphoneNumber(phone, updatedAttendee);
	}
	
	@GetMapping("/sortedByFirstName")
    public List<Attendees> getAttendeesSortedByFirstName() {
        return attendeesService.getAttendeesSortedByFirstName();
    }
	
}
