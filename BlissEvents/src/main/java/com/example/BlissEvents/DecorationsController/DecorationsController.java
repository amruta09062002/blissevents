package com.example.BlissEvents.DecorationsController;

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
import com.example.BlissEvents.DecorationsEntity.Decorations;
import com.example.BlissEvents.DecorationsService.DecorationsService;

@RestController
@RequestMapping("/api/decorations")
public class DecorationsController {

	@Autowired
	DecorationsService decorationservice;
	
	@PostMapping("/insert")
	public String insertDecoations(@RequestBody Decorations decorations) {
		return decorationservice.insertDecoations(decorations);
	}
	
	@GetMapping("/get-all-decorations")
	public ArrayList<Decorations> getAllDecorations(Decorations decorations) {
		return decorationservice.getAllDecorations(decorations);
	}
	
	@GetMapping("/get-decoration-by-id/{decorationId}")
	public Decorations getDecorationById(@PathVariable("decorationId") Long decorationId) {
		return decorationservice.getDecorationById(decorationId);
	}
	
	@GetMapping("/get-decoration-by-type/{decorationType}")
	public List<Decorations> getEventByType(@PathVariable("decorationType") String decorationType) {
		return decorationservice.getEventByType(decorationType);
	}

	@GetMapping("/get-decoration-by-brand/{decorationBrand}")
	public List<Decorations> getEventByBrand(@PathVariable("decorationBrand") String decorationBrand) {
		return decorationservice.getEventByBrand(decorationBrand);
	}
	
	@DeleteMapping("/delete-decoration-by-id/{decorationId}")
	public String deleteDecorationById(@PathVariable("decorationId") Long decorationId) {
		return decorationservice.deleteDecorationById(decorationId);
	}
	
	@DeleteMapping("/delete-decoration-by-type/{decorationType}")
	public String deleteDecorationByType(@PathVariable("decorationType") Long decorationType) {
		return decorationservice.deleteDecorationByType(decorationType);
	}
	
	public String deleteDecorationByBrand(@PathVariable("decorationBrand") Long decorationBrand) {
		return decorationservice.deleteDecorationByBrand(decorationBrand);
	}
	
	@DeleteMapping("/delete-all-decorations")
	public String deleteAllDecorations(Decorations decorations) {
		return decorationservice.deleteAllDecorations(decorations);
	}
	
	@PutMapping("/update-decoration-by-id/{decorationId}")
	public String updateDecorationById(@PathVariable Long decorationId, @RequestBody Decorations updatedecorations) {
		return decorationservice.updateDecorationById(decorationId,updatedecorations);
	}
	
	@PutMapping("/update-decoration-by-type/{decorationType}")
	public String updateDecorationByType(@PathVariable("decorationType") String decorationType, @RequestBody Decorations updatedecorations) {
		return decorationservice.updateDecorationByType(decorationType,updatedecorations);
	}
	
	@PutMapping("/update-decoration-by-brand/{decorationBrand}")
	public String updateDecorationByBrand(@PathVariable("decorationBrand") String decorationBrand, @RequestBody Decorations updatedecorations) {
		return decorationservice.updateDecorationByBrand(decorationBrand,updatedecorations);
	}
}
