package com.example.BlissEvents.CategoryController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlissEvents.CategoryEntity.Categories;
import com.example.BlissEvents.CategoryService.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/insert")
	public String insertCategory(@RequestBody Categories categories) {
		return categoryService.insertCategory(categories);
	}
	
	@GetMapping("/get-all-categories")
	public ArrayList<Categories> getAllCategories(Categories categories) {
		return categoryService.getAllCategories(categories);
	}
	
	@GetMapping("/get-category-by-id/{categoriesId}")
	public Categories getCategoryById(@PathVariable("categoriesId") Long categoriesId) {
		return categoryService.getCategoryById(categoriesId);
	}
	
	@PutMapping("/update-category-by-id/{categoriesId}")
	public String updateCategoryById(@PathVariable Long categoriesId, @RequestBody Categories categories) {
		return categoryService.updateCategoryById(categoriesId,categories);
	}

	@DeleteMapping("/delete-category-by-id/{categoriesId}")
	public String deleteCategoryById(@PathVariable("categoriesId") Long categoriesId) {
		return categoryService.deleteCategoryById(categoriesId);
	}
	
	@DeleteMapping("/delete-all-categories")
	public String deleteAllCategories(Categories categories) {
		return categoryService.deleteAllCategories(categories);
	}
}
