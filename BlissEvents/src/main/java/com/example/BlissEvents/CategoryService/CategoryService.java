package com.example.BlissEvents.CategoryService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlissEvents.CategoryDao.CategoryDao;
import com.example.BlissEvents.CategoryEntity.Categories;
import com.example.BlissEvents.EventsEntity.Events;
import com.example.BlissEvents.EventsMessages.EventsMessages;

@Service
public class CategoryService {

	@Autowired
	CategoryDao categoryDao;

	public String insertCategory(Categories categories) {
		if (categoryDao.insertCategory(categories)) {
			return EventsMessages.insertMessage();
		} else {
			return EventsMessages.notInsertMessage();
		}
	}

	public ArrayList<Categories> getAllCategories(Categories categories) {
		return categoryDao.getAllCategories(categories);
	}

	public Categories getCategoryById(Long categoriesId) {
		if (categoryDao.getCategoryById(categoriesId) != null) {
			return categoryDao.getCategoryById(categoriesId);
		} else {
			EventsMessages.idNotFound();
		}
		return null;
	}

	public String updateCategoryById(Long categoriesId, Categories categories) {
		if (categoryDao.updateCategoryById(categoriesId,categories)) {
			return EventsMessages.updatedMessage();
		} else {
			return EventsMessages.notUpdatedMessage();
		}
	}

	public String deleteCategoryById(Long categoriesId) {
		if(categoryDao.deleteCategoryById(categoriesId)) {
			return EventsMessages.deleteIdMessage();
		}else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

	public String deleteAllCategories(Categories categories) {
		if (categoryDao.deleteAllCategories(categories)) {
			return EventsMessages.deleteIdMessage();
		} else {
			return EventsMessages.NotDeleteIdMessage();
		}
	}

}
