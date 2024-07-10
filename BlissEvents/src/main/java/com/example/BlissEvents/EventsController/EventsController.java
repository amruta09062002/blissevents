package com.example.BlissEvents.EventsController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlissEvents.EventsEntity.Events;
import com.example.BlissEvents.EventsMessages.EventsMessages;
import com.example.BlissEvents.EventsService.EventsService;


@RestController
@RequestMapping("api/events")
public class EventsController {

	@Autowired
	EventsService eventsService;

	@PostMapping("/insert")
	public String insertEvent(@RequestBody Events event) {
		return eventsService.insertEvent(event);
	}

	@GetMapping
	public ArrayList<Events> getAllEvent(Events event) {
		return eventsService.getAllEvent(event);
	}

	@GetMapping("/get-event-by-id/{eventId}")
	public Events getEventById(@PathVariable("eventId") Long eventId) {
		return eventsService.getEventById(eventId);
	}

	@GetMapping("/get-event-by-name/{EventName}")
	public List<Events> getEventByName(@PathVariable("EventName") String eventName) {
		return eventsService.getEventByName(eventName);
	}

	@GetMapping("/get-event-by-date/{eventDate}")
	public List<Events> getEventByDate(
			@PathVariable("eventDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate eventDate) {
		return eventsService.getEventByDate(eventDate);
	}

	@DeleteMapping("/delete-event-by-id/{EventID}")
	public String deleteEventById(@PathVariable("EventID") Long eventId) {
		return eventsService.deleteEventById(eventId);
	}

	@DeleteMapping("/delete-event-by-name/{EventName}")
	public String deleteEventByName(@PathVariable("EventName") String eventName) {
		return eventsService.deleteEventByName(eventName);
	}

	@DeleteMapping("/delete-event-by-date/{eventDate}")
	public String deleteEventByDate(
			@PathVariable("eventDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate eventDate) {
		return eventsService.deleteEventByDate(eventDate);
	}

	@DeleteMapping("/delete-all-events")
	public String deleteAllEvent(Events event) {
		return eventsService.deleteAllEvent(event);
	}
	
	@PutMapping("/update-record-by-id/{EventID}")
	public String updateEventById(@PathVariable Long EventID, @RequestBody Events updatedEvent) {
		return eventsService.updateEventById(EventID,updatedEvent);
	}
	
	@PutMapping("/update-record-by-name/{EventName}")
	public String updateEventByName(@PathVariable String EventName, @RequestBody Events updatedEvent) {
		return eventsService.updateEventByName(EventName,updatedEvent);
	}
	
	@PutMapping("/update-event-by-date/{EventDate}")
	public String updateEventByDate(
			@PathVariable("EventDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate EventDate, @RequestBody Events updatedEvent) {
		return eventsService.updateEventByDate(EventDate, updatedEvent);
	}
	
	@GetMapping("/date-range/{fromDate}/{toDate}")
	public Object getEventsBetweenDates(@PathVariable("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
    @PathVariable("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {
		return eventsService.getEventsBetweenDates(fromDate, toDate);
	}
	
	@GetMapping("/ordered-by-name")
	public Object getEventsOrderedByName() {
		return eventsService.getEventsOrderedByName();
	}
	
	@GetMapping("/ordered-by-name-desc")
	public Object getEventsOrderedByDescName() {
		return eventsService.getEventsOrderedByDescName();
	}
	
	@GetMapping("/ordered-by-date")
	public Object getEventsOrderedByDate() {
		return eventsService.getEventsOrderedByDate();
	}
	
	@GetMapping("/ordered-by-date-desc")
	public Object getEventsOrderedByDescDate() {
		 Object result = eventsService.getEventsOrderedByDescDate();
	        if (result instanceof List) {
	            List<Events> events = (List<Events>) result;
	            if (!events.isEmpty()) {
	                return events;
	            } else {
	                return EventsMessages.errorMessage();
	            }
	        } else {
	            return result;
	        }
	}
}
