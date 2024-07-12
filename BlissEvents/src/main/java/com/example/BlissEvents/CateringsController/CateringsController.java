package com.example.BlissEvents.CateringsController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlissEvents.CateringsService.CateringsService;

@RestController
public class CateringsController {

	@Autowired
	private CateringsService service;
}
