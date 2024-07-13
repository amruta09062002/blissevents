package com.example.BlissEvents.CateringsController;

import java.util.ArrayList;
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
import com.example.BlissEvents.CateringsEntity.Caterings;
import com.example.BlissEvents.CateringsService.CateringsService;

@RestController
@RequestMapping("api/caterings")
public class CateringsController {

	@Autowired
	private CateringsService service;
	
	@PostMapping("/insert-catering")
	public String insertCatering(@RequestBody Caterings caterings) {
		return service.insertCatering(caterings);
	}

	@GetMapping
	public ArrayList<Caterings> getAllCaterings() {
		return service.getAllCaterings();
	}

	@GetMapping("/get-catering-by-id/{cateringID}")
	public Caterings getCateringById(@PathVariable("cateringID") Long cateringID) {
		return service.getCateringById(cateringID);
	}

	@GetMapping("/get-catering-by-name/{cateringName}")
	public List<Caterings> getCateringByName(@PathVariable("cateringName") String name) {
		return service.getCateringByName(name);
	}

	@GetMapping("/get-catering-by-phonenumber/{contactInfo}")
	public Caterings getCateringByPhoneNumber(@PathVariable("contactInfo") String Phone) {
		return service.getCateringByPhoneNumber(Phone);
	}

	@DeleteMapping("/delete-catering-by-id/{cateringID}")
	public String deleteCateringById(@PathVariable("cateringID") Long id) {
		return service.deleteCateringById(id);
	}

	@DeleteMapping("/delete-catering-by-name/{cateringName}")
	public String deleteCateringByName(@PathVariable("cateringName") String name) {
		return service.deleteCateringByName(name);
	}

	@DeleteMapping("/delete-catering-by-phonenumber/{contactInfo}")
	public String deleteCateringByphoneNumber(@PathVariable("contactInfo") String phone) {
		return service.deleteCateringByphoneNumber(phone);
	}

	@DeleteMapping("/delete-all-caterings")
	public String deleteAllCaterings() {
		return service.deleteAllCaterings();
	}

	@PutMapping("/update-catering-by-id/{cateringID}")
	public String updateCateringById(@PathVariable("cateringID") Long id, @RequestBody Caterings updatedCatering) {
		return service.updateCateringById(id, updatedCatering);
	}
	
	@PutMapping("/update-catering-by-name/{cateringName}")
	public String updateCateringByName(@PathVariable("cateringName") String name, @RequestBody Caterings updatedCatering) {
		return service.updateCateringByName(name, updatedCatering);
	}
	
	@PutMapping("/update-catering-by-phonenumber/{contactInfo}")
	public String updateCateringByphoneNumber(@PathVariable("contactInfo") String phone, @RequestBody Caterings updatedCatering) {
		return service.updateCateringByphoneNumber(phone, updatedCatering);
	}
	
	@GetMapping("/sorted-by-name")
    public List<Caterings> getCateringsSortByName() {
        return service.getCateringsSortByName();
    }
	
}
