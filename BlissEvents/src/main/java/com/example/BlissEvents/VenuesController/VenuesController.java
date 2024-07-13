package com.example.BlissEvents.VenuesController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlissEvents.VenuesEntity.Venues;
import com.example.BlissEvents.VenuesService.VenuesService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("api/venues")
public class VenuesController {

	@Autowired
	VenuesService venuesService;

	@PostMapping("/insert")
	public String insertVenues(@RequestBody Venues venue) {
		return venuesService.insertVenues(venue);
	}

	@GetMapping("/get-all-venues")
	public List<Venues> getAllVenues(Venues venue) {
		return venuesService.getAllVenues(venue);
	}

	@GetMapping("/get-venue-by-id/{VenueID}")
	public Venues getVenuesById(@PathVariable("VenueID") Long VenueID) {
		return venuesService.getVenuesById(VenueID);
	}

	@GetMapping("/get-venue-by-name/{VenueName}")
	public List<Venues> getVenuesByName(@PathVariable("VenueName") String venueName) {
		return venuesService.getVenuesByName(venueName);
	}

	@GetMapping("/get-venue-by-location/{Location}")
	public List<Venues> getVenuesByLocation(@PathVariable("Location") String Location) {
		return venuesService.getVenuesByLocation(Location);
	}

	@DeleteMapping("/delete-venue-by-id/{VenueID}")
	public String deleteVenueById(@PathVariable("VenueID") Long VenueID) {
		return venuesService.deleteVenueById(VenueID);
	}

	@DeleteMapping("/delete-venue-by-name/{VenueName}")
	public String deleteVenueByName(@PathVariable("VenueName") String eventName) {
		return venuesService.deleteVenueByName(eventName);
	}

	@DeleteMapping("/delete-venue-by-location/{Location}")
	public String deleteVenuesByLocation(@PathVariable("Location") String Location) {
		return venuesService.deleteVenuesByLocation(Location);
	}

	@DeleteMapping
	public String deleteAllVenues() {
		return venuesService.deleteAllVenues();
	}

	@PutMapping("/update-record-by-id/{VenueID}")
	public String updateVenueById(@PathVariable Long VenueID, @RequestBody Venues updatedVenue) {
		return venuesService.updateVenueById(VenueID, updatedVenue);
	}

	@PutMapping("/update-record-by-name/{VenueName}")
	public String updateVenueByName(@PathVariable String VenueName, @RequestBody Venues updatedVenue) {
		return venuesService.updateVenueByName(VenueName, updatedVenue);
	}

}
