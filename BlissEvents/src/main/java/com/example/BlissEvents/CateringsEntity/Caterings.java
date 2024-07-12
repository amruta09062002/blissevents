package com.example.BlissEvents.CateringsEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Caterings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cateringID;
	private String cateringName;
	private String cateringMenu;
	private String contactInfo;

}
