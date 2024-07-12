package com.example.BlissEvents.PhotographerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/insert")
	public void addPhotographer(@RequestBody Photographers photographer) {
		service.addPhotographer(photographer);
	}
}
