package com.example.BlissEvents.LightsDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BlissEvents.EventsEntity.Events;
import com.example.BlissEvents.EventsMessages.EventsMessages;
import com.example.BlissEvents.LightsEntity.Lights;

@Repository
public class LightsDao {
	
	@Autowired
	SessionFactory factory;

	public boolean insertLights(Lights light) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(light);
			transaction.commit();
			return true;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return true;
	}

	public ArrayList<Lights> getAllLights(Lights light) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			ArrayList<Lights> lightList = (ArrayList<Lights>) session.createQuery("from Lights", Lights.class).list();
			transaction.commit();
			return lightList;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return null;
	}

	public Lights getLightById(Long lightId) {
		Session session = null;
		Lights light = null;
		try {
			session = factory.openSession();
			light = session.get(Lights.class, lightId);
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return light;
	}

	public List<Lights> getLightByType(String lightType) {
		List<Lights> light = null;
		//try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Events.class);
			criteria.add(Restrictions.eq("LightType", lightType));
			transaction.commit();
			light = criteria.list();
//		} catch (Exception e) {
//			//EventsMessages.errorMessage();
//			e.printStackTrace();
//		}
		return light;
	}

	public List<Lights> getLightByBrand(String lightType) {
		List<Lights> light = null;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Events.class);
			criteria.add(Restrictions.eq("lightType", lightType));
			transaction.commit();
			light = criteria.list();
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return light;
	}

	public boolean deleteLightById(Long lightId) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Lights light = session.get(Lights.class, lightId);
			session.delete(light);
			transaction.commit();
			return true;
		} catch (Exception e) {
			EventsMessages.NotDeleteIdMessage();
		}
		return true;
	}

	public boolean deleteLightByType(String lightType) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Events.class);
			criteria.add(Restrictions.eq("lightType", lightType));
			List<Lights> light = criteria.list();
			for (Lights lite : light) {
				session.delete(lite);
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			EventsMessages.errorMessage();
		}
		return true;
	}

	public boolean deleteLightByBrand(String lightBrand) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Events.class);
			criteria.add(Restrictions.eq("lightBrand", lightBrand));
			List<Lights> light = criteria.list();
			for (Lights lite : light) {
				session.delete(lite);
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			EventsMessages.errorMessage();
		}
		return true;
	}

	public String updateLightById(Long lightId, Lights updatedLights) {
		Transaction transaction = null;
		Lights light = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			light = session.get(Lights.class, lightId);
			if (light != null) {
				light.setEvent(updatedLights.getEvent());
				light.setLightBrand(updatedLights.getLightBrand());
				light.setLightId(updatedLights.getLightId());
				light.setLightQuantity(updatedLights.getLightQuantity());
				light.setLightType(updatedLights.getLightType());
				session.update(light);
				transaction.commit();
				return EventsMessages.updatedMessage();
			} else {
				return EventsMessages.notUpdatedMessage();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return EventsMessages.errorMessage();
		}
	}

	public Object updateLightByBrand(String lightBrand, Lights updatedLights) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Lights.class);
			criteria.add(Restrictions.eq("lightBrand", lightBrand));
			List<Lights> light = criteria.list();
			if (light != null && !light.isEmpty()) {
				for (Lights lite : light) {
					lite.setEvent(updatedLights.getEvent());
					lite.setLightBrand(updatedLights.getLightBrand());
					lite.setLightId(updatedLights.getLightId());
					lite.setLightQuantity(updatedLights.getLightQuantity());
					lite.setLightType(updatedLights.getLightType());
					session.update(lite);
				}
				transaction.commit();
				return EventsMessages.updatedMessage();
			} else {
				return EventsMessages.notUpdatedMessage();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return EventsMessages.errorMessage();
		}
	}

}
