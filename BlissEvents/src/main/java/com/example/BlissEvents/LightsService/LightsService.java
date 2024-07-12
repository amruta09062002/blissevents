package com.example.BlissEvents.LightsService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.EventsEntity.Events;
import com.example.BlissEvents.EventsMessages.EventsMessages;
import com.example.BlissEvents.LightsDao.LightsDao;
import com.example.BlissEvents.LightsEntity.Lights;

@Service
public class LightsService {
	
	@Autowired
	private LightsDao lightdao;

	public String insertLights(Lights light) {
		if (lightdao.insertLights(light)) {
			return EventsMessages.insertMessage();
		} else {
			return EventsMessages.notInsertMessage();
		}
	}

	public ArrayList<Lights> getAllLights(Lights light) {
		return lightdao.getAllLights(light);
	}

	public Lights getLightById(Long lightId) {
		if (lightdao.getLightById(lightId) != null) {
			return lightdao.getLightById(lightId);
		} else {
			EventsMessages.idNotFound();
		}
		return null;
	}

	public List<Lights> getLightByType(String lightType) {
		if (lightdao.getLightByType(lightType) != null) {
			return lightdao.getLightByType(lightType);
		} else {
			EventsMessages.EventNotFound();
		}
		return null;
	}

	public List<Lights> getLightByBrand(String lightType) {
		if (lightdao.getLightByBrand(lightType) != null) {
			return lightdao.getLightByBrand(lightType);
		} else {
			EventsMessages.EventNotFound();
		}
		return null;
	}

	public String deleteLightById(Long lightId) {
		if (lightdao.deleteLightById(lightId)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

	public String deleteLightByType(String lightType) {
		if (lightdao.deleteLightByType(lightType)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

	public String deleteLightByBrand(String lightBrand) {
		if (lightdao.deleteLightByBrand(lightBrand)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

	public String updateLightById(Long lightId, Lights updatedLights) {
		if (lightdao.updateLightById(lightId, updatedLights) != null) {
			return EventsMessages.updatedMessage();
		} else {
			return EventsMessages.notUpdatedMessage();
		}
	}

	public String updateLightByBrand(String lightBrand, Lights updatedLights) {
		if (lightdao.updateLightByBrand(lightBrand, updatedLights) != null) {
			return EventsMessages.updatedMessage();
		} else {
			return EventsMessages.notUpdatedMessage();
		}
	}

}
