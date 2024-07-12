package com.example.BlissEvents.CategoryEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long categoriesId;
	String categoriesName;
	
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Categories(String categoriesName) {
		super();
		this.categoriesName = categoriesName;
	}

	public long getCategoriesId() {
		return categoriesId;
	}

	public void setCategoriesId(int categoriesId) {
		this.categoriesId = categoriesId;
	}

	public String getCategoriesName() {
		return categoriesName;
	}

	public void setCategoriesName(String categoriesName) {
		this.categoriesName = categoriesName;
	}

	
}
