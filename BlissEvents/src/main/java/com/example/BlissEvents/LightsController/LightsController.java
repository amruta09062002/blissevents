package com.example.BlissEvents.LightsController;

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

import com.example.BlissEvents.LightsEntity.Lights;
import com.example.BlissEvents.LightsService.LightsService;

@RestController
@RequestMapping("api/lights")
public class LightsController {
	
	@Autowired
	private LightsService lightservice;
	
	@PostMapping("/insert")
	public String insertLights(@RequestBody Lights light) {
		return lightservice.insertLights(light);
	}
	
	@GetMapping("/get-all-lights")
	public ArrayList<Lights> getAllLights(Lights light) {
		return lightservice.getAllLights(light);
	}
	
	@GetMapping("/get-light-by-id/{lightId}")
	public Lights getLightById(@PathVariable("lightId") Long lightId) {
		return lightservice.getLightById(lightId);
	}
	
	@GetMapping("/get-light-by-type/{lightType}")
	public List<Lights> getLightByType(@PathVariable("lightType") String lightType) {
		return lightservice.getLightByType(lightType);
	}
	
	@GetMapping("/get-light-by-brand/{lightBrand}")
	public List<Lights> getLightByBrand(@PathVariable("lightType") String lightType) {
		return lightservice.getLightByBrand(lightType);
	}
	
	@DeleteMapping("/delete-light-by-id/{lightId}")
	public String deleteLightById(@PathVariable("lightId") Long lightId) {
		return lightservice.deleteLightById(lightId);
	}
	
	@DeleteMapping("/delete-light-by-type/{lightType}")
	public String deleteLightByType(@PathVariable("lightType") String lightType) {
		return lightservice.deleteLightByType(lightType);
	}
	
	@DeleteMapping("/delete-light-by-brand/{lightBrand}")
	public String deleteLightByBrand(@PathVariable("lightBrand") String lightBrand) {
		return lightservice.deleteLightByBrand(lightBrand);
	}
	
	@PutMapping("/update-record-by-id/{lightId}")
	public String updateLightById(@PathVariable Long lightId, @RequestBody Lights updatedLights) {
		return lightservice.updateLightById(lightId,updatedLights);
	}
	
	@PutMapping("/update-record-by-brand/{lightBrand}")
	public String updateLightByBrand(@PathVariable String lightBrand, @RequestBody Lights updatedLights) {
		return lightservice.updateLightByBrand(lightBrand,updatedLights);
	}

}
