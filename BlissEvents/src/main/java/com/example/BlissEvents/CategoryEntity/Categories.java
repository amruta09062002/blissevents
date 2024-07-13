package com.example.BlissEvents.CategoryEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoriesId;
	private String categoriesName;
	public long getCategoriesId() {
		return categoriesId;
	}
	public void setCategoriesId(long categoriesId) {
		this.categoriesId = categoriesId;
	}
	public String getCategoriesName() {
		return categoriesName;
	}
	public void setCategoriesName(String categoriesName) {
		this.categoriesName = categoriesName;
	}
	
	
	
	

}
