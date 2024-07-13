package com.example.BlissEvents.DecorationsService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.DecorationsDao.DecorationsDao;
import com.example.BlissEvents.DecorationsEntity.Decorations;
import com.example.BlissEvents.EventsMessages.EventsMessages;

@Service
public class DecorationsService {
	@Autowired
	DecorationsDao decorationsDao;

	public String insertDecoations(Decorations decorations) {
		if (decorationsDao.insertDecoations(decorations)) {
			return EventsMessages.insertMessage();
		} else {
			return EventsMessages.notInsertMessage();
		}
	}

	public ArrayList<Decorations> getAllDecorations(Decorations decorations) {
		return decorationsDao.getAllDecorations(decorations);
	}

	public Decorations getDecorationById(Long decorationId) {
		if (decorationsDao.getDecorationById(decorationId) != null) {
			return decorationsDao.getDecorationById(decorationId);
		} else {
			EventsMessages.idNotFound();
		}
		return null;
	}

	public List<Decorations> getEventByType(String decorationType) {
		if (decorationsDao.getEventByType(decorationType) != null) {
			return decorationsDao.getEventByType(decorationType);
		} else {
			EventsMessages.notDisplayMessage();
		}
		return null;
	}

	public List<Decorations> getEventByBrand(String decorationBrand) {
		if (decorationsDao.getEventByBrand(decorationBrand) != null) {
			return decorationsDao.getEventByBrand(decorationBrand);
		} else {
			EventsMessages.notDisplayMessage();
		}
		return null;
	}

	public String deleteDecorationById(Long decorationId) {
		if (decorationsDao.deleteDecorationById(decorationId)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

	public String deleteDecorationByType(String decorationType) {
		if (decorationsDao.deleteDecorationByType(decorationType)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

	public String deleteDecorationByBrand(String decorationBrand) {
		if (decorationsDao.deleteDecorationByBrand(decorationBrand)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

	public String deleteAllDecorations(Decorations decorations) {
		if (decorationsDao.deleteAllDecorations(decorations)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

	public String updateDecorationById(Long decorationId, Decorations updatedecorations) {
		if (decorationsDao.updateDecorationById(decorationId, updatedecorations) != null) {
			return EventsMessages.updatedMessage();
		} else {
			return EventsMessages.notUpdatedMessage();
		}
	}

	public String updateDecorationByType(String decorationType, Decorations updatedecorations) {
		if (decorationsDao.updateDecorationByType(decorationType, updatedecorations) != null) {
			return EventsMessages.updatedMessage();
		} else {
			return EventsMessages.notUpdatedMessage();
		}
	}

	public String updateDecorationByBrand(String decorationBrand, Decorations updatedecorations) {
		if (decorationsDao.updateDecorationByBrand(decorationBrand, updatedecorations) != null) {
			return EventsMessages.updatedMessage();
		} else {
			return EventsMessages.notUpdatedMessage();
		}
	}
}
