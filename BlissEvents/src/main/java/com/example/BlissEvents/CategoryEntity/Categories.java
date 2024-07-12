package com.example.BlissEvents.CategoryEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categories {
	@Id
	long categoryId;
	String categoryName;
	
	

}
