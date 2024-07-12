package com.example.BlissEvents.PhotographerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.PhotographerDao.PhotographerDao;

@Service
public class PhotographerService {

	@Autowired
	private PhotographerDao dao;
}
