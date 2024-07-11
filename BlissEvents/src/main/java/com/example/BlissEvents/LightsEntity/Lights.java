package com.example.BlissEvents.LightsEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lights {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long LightId;
	private String LightType;
	private String LightBrand;
	private int LightQuantity;
	
}
