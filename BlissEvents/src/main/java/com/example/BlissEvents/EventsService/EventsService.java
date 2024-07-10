package com.example.BlissEvents.EventsService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.EventsDao.EventsDao;
import com.example.BlissEvents.EventsEntity.Events;
import com.example.BlissEvents.EventsMessages.EventsMessages;

@Service
public class EventsService {

	@Autowired
	EventsDao eventsDao;

	public String insertEvent(Events event) {
		if (eventsDao.insertEvent(event)) {
			return EventsMessages.insertMessage();
		} else {
			return EventsMessages.notInsertMessage();
		}
	}

	public ArrayList<Events> getAllEvent(Events event) {
		return eventsDao.getAllEvent(event);
	}

	public Events getEventById(Long eventId) {
		if (eventsDao.getEventById(eventId) != null) {
			return eventsDao.getEventById(eventId);
		} else {
			EventsMessages.idNotFound();
		}
		return null;
	}

	public List<Events> getEventByName(String eventName) {
		if (eventsDao.getEventByName(eventName) != null) {
			return eventsDao.getEventByName(eventName);
		} else {
			EventsMessages.EventNotFound();
		}
		return null;
	}

	public List<Events> getEventByDate(LocalDate eventDate) {
		if (eventsDao.getEventByDate(eventDate) != null) {
			return eventsDao.getEventByDate(eventDate);
		} else {
			EventsMessages.EvenDatetNotFound();
		}
		return null;
	}

	public String deleteEventById(Long eventId) {
		if (eventsDao.deleteEventById(eventId)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}

	}

	public String deleteEventByName(String eventName) {
		if (eventsDao.deleteEventByName(eventName)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

	public String deleteEventByDate(LocalDate eventDate) {
		if (eventsDao.deleteEventByDate(eventDate)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.EvenDatetNotFound();
		}

	}

	public String deleteAllEvent(Events event) {
		if (eventsDao.deleteAllEvent(event) != null) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.EvenDatetNotFound();
		}
	}

	public String updateEventById(Long EventID, Events updatedEvent) {
		if (eventsDao.updateEventById(EventID, updatedEvent) != null) {
			return EventsMessages.updatedMessage();
		} else {
			return EventsMessages.notUpdatedMessage();
		}
	}

	public String updateEventByName(String EventName, Events updatedEvent) {
		if (eventsDao.updateEventByName(EventName, updatedEvent) != null) {
			return EventsMessages.updatedMessage();
		} else {
			return EventsMessages.notUpdatedMessage();
		}
	}

	public String updateEventByDate(LocalDate EventDate, Events updatedEvent) {
		if (eventsDao.updateEventByDate(EventDate, updatedEvent) != null) {
			return EventsMessages.updatedMessage();
		} else {
			return EventsMessages.notUpdatedMessage();
		}
	}

	public Object getEventsBetweenDates(LocalDate fromDate, LocalDate toDate) {
		List<Events> event = eventsDao.getEventsBetweenDates(fromDate, toDate);
		if ( event!= null && !event.isEmpty()) {
			return event;
		} else {
			return EventsMessages.notDisplayMessage();
		}
	}

	public Object getEventsOrderedByName() {
		List<Events> event = eventsDao.getEventsOrderedByName();
		if(event != null && !event.isEmpty()) {
			return event;
		}else {
			return EventsMessages.errorMessage();
		}
	}
	
	public Object getEventsOrderedByDescName() {
		List<Events> event = eventsDao.getEventsOrderedByDescName();
		if(event != null && !event.isEmpty()) {
			return event;
		}else {
			return EventsMessages.errorMessage();
		}
	}

	public Object getEventsOrderedByDate() {
		List<Events> event = eventsDao.getEventsOrderedByDate();
		if(event != null && !event.isEmpty()) {
			return event;
		}else {
			return EventsMessages.errorMessage();
		}
	}
	
	public Object getEventsOrderedByDescDate() {
		List<Events> event = eventsDao.getEventsOrderedByDescDate();
		if(event != null && !event.isEmpty()) {
			return event;
		}else {
			return EventsMessages.errorMessage();
		}
	}

	

}
