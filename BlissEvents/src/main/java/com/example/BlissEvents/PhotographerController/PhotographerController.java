package com.example.BlissEvents.PhotographerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlissEvents.PhotographerService.PhotographerService;

@RestController
public class PhotographerController {
	
	@Autowired
	private PhotographerService service;
}
