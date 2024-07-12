package com.example.BlissEvents.CategoryDao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BlissEvents.CategoryEntity.Categories;
import com.example.BlissEvents.EventsEntity.Events;
import com.example.BlissEvents.EventsMessages.EventsMessages;

@Repository
public class CategoryDao {
	@Autowired
	SessionFactory factory;

	public boolean insertCategory(Categories categories) {
		Transaction transaction = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(categories);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			return true;
		}
	}

	public ArrayList<Categories> getAllCategories(Categories categories) {
		Session session = null;
		ArrayList<Categories> clist = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Categories.class);
			clist = (ArrayList<Categories>) criteria.list();
			session.close();
			return clist;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return clist;
	}

	public Categories getCategoryById(Long categoriesId) {

		Session session = null;
		Categories categories = null;
		try {
			session = factory.openSession();
			categories = session.get(Categories.class, categoriesId);
			session.close();
			return categories;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return categories;
	}

	public boolean updateCategoryById(Long categoriesId, Categories updatecategories) {

		Transaction transaction = null;
		Categories categories = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			categories = session.get(Categories.class, categoriesId);
			if (categories != null) {
				categories.setCategoriesName(updatecategories.getCategoriesName());
				session.save(categories);
			}
			transaction.commit();
			session.close();
			return true;

		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		}
		return true;
	}

	public boolean deleteCategoryById(Long categoriesId) {
		Transaction transaction = null;
		Categories categories = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			categories = session.load(Categories.class, categoriesId);
			session.delete(categories);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		}
		return true;
	}

	public boolean deleteAllCategories(Categories categories) {
		Transaction transaction = null;
		try {
			Session session = factory.openSession();
			transaction=session.beginTransaction();
			session.delete(categories);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			if(transaction!=null)
				transaction.rollback();
		}
		return true;
	}

}
