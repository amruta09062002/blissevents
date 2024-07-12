package com.example.BlissEvents.CateringsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.CateringsDao.CateringsDao;

@Service
public class CateringsService {
	
	@Autowired
	private CateringsDao dao;
}
