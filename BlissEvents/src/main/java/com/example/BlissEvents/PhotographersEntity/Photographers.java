package com.example.BlissEvents.PhotographersEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Photographers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long photographerID;
	private String photographerName;
	private String contactInfo;
}
