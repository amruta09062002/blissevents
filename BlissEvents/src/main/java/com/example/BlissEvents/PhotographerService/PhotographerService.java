package com.example.BlissEvents.PhotographerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.PhotographerDao.PhotographerDao;
import com.example.BlissEvents.PhotographersEntity.Photographers;

@Service
public class PhotographerService {

	@Autowired
	private PhotographerDao dao;

	public void addPhotographer(Photographers photographer) {
		dao.addPhotographer(photographer);
	}
}
