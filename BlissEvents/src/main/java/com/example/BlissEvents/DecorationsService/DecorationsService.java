package com.example.BlissEvents.DecorationsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.DecorationsDao.DecorationsDao;

@Service
public class DecorationsService {

	@Autowired
	DecorationsDao dao;
}
