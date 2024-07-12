package com.example.BlissEvents.SoundsController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlissEvents.SoundsService.SoundsService;

@RestController
@RequestMapping("/api/sounds")
public class SoundsController {
	
	@Autowired
	SoundsService service;

}
