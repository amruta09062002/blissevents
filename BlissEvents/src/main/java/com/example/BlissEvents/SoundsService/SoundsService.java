package com.example.BlissEvents.SoundsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.SoundsDao.SoundsDao;

@Service
public class SoundsService {

	@Autowired
	SoundsDao dao;

}
