package com.example.BlissEvents.SoundsController;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;

>>>>>>> refs/remotes/origin/Akash
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> refs/remotes/origin/Akash
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
=======
import com.example.BlissEvents.SoundsEntity.Sounds;
>>>>>>> refs/remotes/origin/Akash
import com.example.BlissEvents.SoundsService.SoundsService;

@RestController
@RequestMapping("/api/sounds")
public class SoundsController {

	@Autowired
<<<<<<< HEAD
	SoundsService service;
=======
	SoundsService soundService;

	@PostMapping("/insert")
	public String insertSounds(@RequestBody Sounds sounds) {
		return soundService.insertSounds(sounds);
	}

	@GetMapping("/get-all-sounds")
	public ArrayList<Sounds> getAllsounds(Sounds sounds) {
		return soundService.getAllsounds(sounds);
	}

	@GetMapping("/get-sound-by-id/{soundId}")
	public Sounds getSoundById(@PathVariable("soundId") Long soundId) {
		return soundService.getSoundById(soundId);
	}

	@GetMapping("/get-sounds-by-type/{soundType}")
	public List<Sounds> getSoundByType(@PathVariable("soundType") String soundType) {
		return soundService.getSoundByType(soundType);
	}

	@GetMapping("/get-sounds-by-brand/{soundBrand}")
	public List<Sounds> getSoundByBrand(@PathVariable("soundBrand") String soundBrand) {
		return soundService.getSoundByBrand(soundBrand);
	}
	
	@DeleteMapping("/delete-sound-by-id/{soundId}")
	public String deleteSoundsById(@PathVariable("soundId") Long soundId) {
		return soundService.deleteSoundstById(soundId);
	}

	@DeleteMapping("/delete-Sound-by-type/{soundType}")
	public String deleteSoundByType(@PathVariable("soundType") String soundType) {
		return soundService.deleteSoundByType(soundType);
	}

	@DeleteMapping("/delete-Sound-by-brand/{soundBrand}")
	public String deleteSoundByBrand(@PathVariable("soundBrand") String soundBrand) {
		return soundService.deleteSoundByBrand(soundBrand);
	}
	
	@DeleteMapping("/delete-all-sounds")
	public String deleteAllSounds(Sounds sounds) {
		return soundService.deleteAllSounds(sounds);
	}

	@PutMapping("/update-sound-by-id/{soundId}")
	public String updateSoundById(@PathVariable Long soundId, @RequestBody Sounds updateSound) {
		return soundService.updateSoundById(soundId, updateSound);
	}

	@PutMapping("/update-sound-by-brand/{soundBrand}")
	public String updateSoundByBrand(@PathVariable String soundBrand, @RequestBody Sounds updateSound) {
		return soundService.updateSoundByBrand(soundBrand, updateSound);
	}
	
	@PutMapping("/update-sound-by-type/{soundType}")
	public String updateSoundByType(@PathVariable String soundType, @RequestBody Sounds updateSound) {
		return soundService.updateSoundByType(soundType, updateSound);
	}
	
	
	
>>>>>>> refs/remotes/origin/Akash

}
