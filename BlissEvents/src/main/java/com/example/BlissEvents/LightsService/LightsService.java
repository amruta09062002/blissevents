package com.example.BlissEvents.LightsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.LightsDao.LightsDao;

@Service
public class LightsService {
	
	@Autowired
	private LightsDao lightdao;

}
