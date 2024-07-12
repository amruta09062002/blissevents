package com.example.BlissEvents.SoundsController;

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
import com.example.BlissEvents.SoundsEntity.Sounds;
import com.example.BlissEvents.SoundsService.SoundsService;

@RestController
@RequestMapping("/api/sounds")
public class SoundsController {
	
	@Autowired
	SoundsService soundService;
	
	@PostMapping("/insert")
	public String insertSounds(@RequestBody Sounds sounds) {
		return soundService.insertSounds(sounds);
	}

	@GetMapping("/get-all-sounds")
	public ArrayList<Sounds> getAllsounds(Sounds sounds) {
		return soundService.getAllsounds(sounds);
	}

	@GetMapping("/get-sound-by-id/{soundId}")
	public Sounds getSoundById(@PathVariable("soundId") Long soundId) {
		return soundService.getSoundById(soundId);
	}

	@GetMapping("/get-sounds-by-type/{soundType}")
	public List<Sounds> getSoundByType(@PathVariable("soundType") String soundType) {
		return soundService.getSoundByType(soundType);
	}


	@DeleteMapping("/delete-sound-by-id/{soundId}")
	public String deleteSoundsById(@PathVariable("soundId") Long soundId) {
		return soundService.deleteSoundstById(soundId);
	}

	@DeleteMapping("/delete-Sound-by-type/{soundType}")
	public String deleteSoundByType(@PathVariable("soundType") String soundType) {
		return soundService.deleteSoundByType(soundType);
	}

	@DeleteMapping("/delete-all-sounds")
	public String deleteAllSounds(Sounds sounds) {
		return soundService.deleteAllSounds(sounds);
	}
	
	@PutMapping("/update-record-by-id/{soundId}")
	public String updateSoundById(@PathVariable Long soundId, @RequestBody Sounds updateSound) {
		return soundService.updateSoundById(soundId,updateSound);
	}
	
	@PutMapping("/update-record-by-name/{EventName}")
	public String updateEventByName(@PathVariable String EventName, @RequestBody Events updatedEvent) {
		return soundService.updateEventByName(EventName,updatedEvent);
	}
	
	@PutMapping("/update-event-by-date/{EventDate}")
	public String updateEventByDate(
			@PathVariable("EventDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate EventDate, @RequestBody Events updatedEvent) {
		return soundService.updateEventByDate(EventDate, updatedEvent);
	}
	
	@GetMapping("/date-range/{fromDate}/{toDate}")
	public Object getEventsBetweenDates(@PathVariable("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
    @PathVariable("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {
		return soundService.getEventsBetweenDates(fromDate, toDate);
	}
	
	@GetMapping("/ordered-by-name")
	public Object getEventsOrderedByName() {
		return soundService.getEventsOrderedByName();
	}
	
	@GetMapping("/ordered-by-name-desc")
	public Object getEventsOrderedByDescName() {
		return soundService.getEventsOrderedByDescName();
	}
	
	@GetMapping("/ordered-by-date")
	public Object getEventsOrderedByDate() {
		return soundService.getEventsOrderedByDate();
	}
	
	@GetMapping("/ordered-by-date-desc")
	public Object getEventsOrderedByDescDate() {
		 Object result = soundService.getEventsOrderedByDescDate();
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
