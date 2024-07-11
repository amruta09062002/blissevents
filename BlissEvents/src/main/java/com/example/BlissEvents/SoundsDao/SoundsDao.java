package com.example.BlissEvents.SoundsDao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SoundsDao {

	@Autowired
	SessionFactory factory;
}
