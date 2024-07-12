package com.example.BlissEvents.DecorationsController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlissEvents.DecorationsService.DecorationsService;

@RestController
@RequestMapping("/api/decorations")
public class DecorationsController {

	@Autowired
	DecorationsService service;
}
