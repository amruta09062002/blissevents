package com.example.BlissEvents.CategoryEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long categoryId;
	String categoryName;
	
	
 
}
