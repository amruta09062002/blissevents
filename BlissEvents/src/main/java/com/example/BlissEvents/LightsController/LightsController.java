package com.example.BlissEvents.LightsController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlissEvents.LightsService.LightsService;

@RestController
public class LightsController {
	
	@Autowired
	private LightsService lightservice;

}
