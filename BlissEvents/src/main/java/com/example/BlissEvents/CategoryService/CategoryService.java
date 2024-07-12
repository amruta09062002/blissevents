package com.example.BlissEvents.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.CategoryDao.CategoryDao;

@Service
public class CategoryService {

	@Autowired
	CategoryDao dao;

}
