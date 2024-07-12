package com.example.BlissEvents.PhotographerDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BlissEvents.PhotographersEntity.Photographers;

@Repository
public class PhotographerDao {

    @Autowired
    private SessionFactory factory;

    public void addPhotographer(Photographers photographer) {
        
        try {
        	Session session = factory.openSession();
        	Transaction transaction = session.beginTransaction();
            session.save(photographer);
            transaction.commit();
        } catch (Exception e) {
           System.out.println("Exception occured.");
        } 
    }
}
