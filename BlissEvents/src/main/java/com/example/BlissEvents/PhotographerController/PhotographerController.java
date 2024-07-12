package com.example.BlissEvents.PhotographerController;

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

import com.example.BlissEvents.PhotographerService.PhotographerService;
import com.example.BlissEvents.PhotographersEntity.Photographers;

@RestController
@RequestMapping("/api/photographer")
public class PhotographerController {
	
	@Autowired
	private PhotographerService service;
	
	@PostMapping("/insert-photographer")
	public String addPhotographer(@RequestBody Photographers photographer) {
		return service.addPhotographer(photographer);
	}
	
	@GetMapping
	public List<Photographers> getAllPhotographers() {
		return service.getAllPhotographers();
	}

	@GetMapping("/get-photographer-by-id/{photographerID}")
	public Photographers getPhotographerById(@PathVariable("photographerID") Long id) {
		return service.getPhotographerById(id);
	}

	@GetMapping("/get-photographer-by-name/{photographerName}")
	public List<Photographers> getPhotographerByName(@PathVariable("photographerName") String name) {
		return service.getPhotographerByName(name);
	}

	@GetMapping("/get-photographer-by-phonenumber/{contactInfo}")
	public Photographers getPhotographerByPhoneNumber(@PathVariable("contactInfo") String Phone) {
		return service.getPhotographerByPhoneNumber(Phone);
	}

	@DeleteMapping("/delete-photographer-by-id/{photographerID}")
	public String deletePhotographerById(@PathVariable("photographerID") Long id) {
		return service.deletePhotographerById(id);
	}

	@DeleteMapping("/delete-photographer-by-firstname/{photographerName}")
	public String deletePhotographerByName(@PathVariable("photographerName") String name) {
		return service.deletePhotographerByName(name);
	}

	@DeleteMapping("/delete-photographer-by-phonenumber/{contactInfo}")
	public String deletePhotographerByphoneNumber(@PathVariable("contactInfo") String phone) {
		return service.deletePhotographerByphoneNumber(phone);
	}

	@DeleteMapping("/delete-all-photographers")
	public String deleteAllPhotographers() {
		return service.deleteAllPhotographers();
	}

	@PutMapping("/update-photographer-by-id/{photographerID}")
	public String updatePhotographerById(@PathVariable("photographerID") Long id, @RequestBody Photographers updatedPhotographer) {
		return service.updatePhotographerById(id, updatedPhotographer);
	}
	
	@PutMapping("/update-photographer-by-name/{photographerName}")
	public String updatePhotographerByName(@PathVariable("photographerName") String name, @RequestBody Photographers updatedPhotographer) {
		return service.updatePhotographerByName(name, updatedPhotographer);
	}
	
	@PutMapping("/update-photographer-by-phonenumber/{contactInfo}")
	public String updatePhotographerByphoneNumber(@PathVariable("contactInfo") String phone, @RequestBody Photographers updatedPhotographer) {
		return service.updatePhotographerByphoneNumber(phone, updatedPhotographer);
	}
	
	@GetMapping("/sort-by-name")
    public List<Photographers> getPhotographersSortByName() {
        return service.getPhotographersSortByName();
    }
}
