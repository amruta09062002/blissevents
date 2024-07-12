package com.example.BlissEvents.SoundsService;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.EventsEntity.Events;
import com.example.BlissEvents.EventsMessages.EventsMessages;
import com.example.BlissEvents.SoundsDao.SoundsDao;
import com.example.BlissEvents.SoundsEntity.Sounds;
import com.zaxxer.hikari.util.ClockSource.Factory;

@Service
public class SoundsService {

	@Autowired
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
		if (SoundsDao.updateSoundById(soundId, updateSound)!=null) {
			return EventsMessages.updatedMessage();
		} else {
			return EventsMessages.notUpdatedMessage();
		}
	}

}
