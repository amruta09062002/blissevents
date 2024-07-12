package com.example.BlissEvents.SoundsService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.EventsMessages.EventsMessages;
import com.example.BlissEvents.SoundsDao.SoundsDao;
import com.example.BlissEvents.SoundsEntity.Sounds;

@Service
public class SoundsService {

	@Autowired
<<<<<<< HEAD
<<<<<<< HEAD
	SoundsDao dao;
=======
=======
>>>>>>> refs/remotes/origin/Akash
	SoundsDao soundsDao;

	public String insertSounds(Sounds sounds) {
		if (soundsDao.insertSounds(sounds)) {
			return EventsMessages.insertMessage();
		} else {
			return EventsMessages.errorMessage();
		}
	}

	public ArrayList<Sounds> getAllsounds(Sounds sounds) {
		return soundsDao.getAllsounds(sounds);
	}

	public Sounds getSoundById(Long soundId) {
		if (soundsDao.getSoundById(soundId) != null) {
			return soundsDao.getSoundById(soundId);
		} else {
			EventsMessages.idNotFound();
		}
		return null;
	}

	public List<Sounds> getSoundByType(String soundType) {
		if (soundsDao.getSoundByType(soundType) != null) {
			return soundsDao.getSoundByType(soundType);
		} else {
			EventsMessages.errorMessage();
		}
		return null;
	}

	public String deleteSoundstById(Long soundId) {
		if (soundsDao.deleteSoundstById(soundId)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

	public String deleteSoundByType(String soundType) {
		if (soundsDao.deleteSoundByType(soundType)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

	public String deleteAllSounds(Sounds sounds) {
		if (soundsDao.deleteAllSounds(sounds)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

	public String updateSoundById(Long soundId, Sounds updateSound) {
		if (soundsDao.updateSoundById(soundId, updateSound) != null) {
			return EventsMessages.updatedMessage();
		} else {
			return EventsMessages.notUpdatedMessage();
		}
	}

	public String updateSoundByType(String soundType, Sounds updateSound) {
		if (soundsDao.updateSoundByType(soundType, updateSound) != null) {
			return EventsMessages.updatedMessage();
		} else {
			return EventsMessages.notUpdatedMessage();
		}
	}

	public String deleteSoundByBrand(String soundBrand) {
		if (soundsDao.deleteSoundByBrand(soundBrand)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

	public List<Sounds> getSoundByBrand(String soundBrand) {
		if (soundsDao.getSoundByBrand(soundBrand) != null) {
			return  soundsDao.getSoundByBrand(soundBrand);
		} else {
			EventsMessages.errorMessage();
		}
		return null;
	}

	public String updateSoundByBrand(String soundBrand, Sounds updateSound) {
		if (soundsDao.updateSoundByBrand(soundBrand, updateSound) != null) {
			return EventsMessages.updatedMessage();
		} else {
			return EventsMessages.notUpdatedMessage();
		}
	}
<<<<<<< HEAD
>>>>>>> refs/remotes/origin/Akash

=======
>>>>>>> refs/remotes/origin/Akash
}
