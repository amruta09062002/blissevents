package com.example.BlissEvents.SoundsDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BlissEvents.EventsMessages.EventsMessages;
import com.example.BlissEvents.SoundsEntity.Sounds;

@Repository
public class SoundsDao {

	@Autowired
	SessionFactory factory;

	public boolean insertSounds(Sounds sounds) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(sounds);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public ArrayList<Sounds> getAllsounds(Sounds sounds) {
		ArrayList<Sounds> soundslist = null;
		try {
			Session session = factory.openSession();
			Transaction transaction=session.beginTransaction();
			Criteria criteria = session.createCriteria(Sounds.class);
			soundslist = (ArrayList<Sounds>) criteria.list();
			transaction.commit();
			session.close();
			return soundslist;
		} catch (Exception e) {
			EventsMessages.displayMessage();
		}
		return soundslist;
	}

	public Sounds getSoundById(Long soundId) {
		Session session = null;
		Sounds sounds = null;
		try {
			session = factory.openSession();
			sounds = session.get(Sounds.class, soundId);
			session.close();
			return sounds;
		} catch (Exception e) {
			EventsMessages.idNotFound();
		}
		return sounds;
	}

	public List<Sounds> getSoundByType(String soundType) {
		List<Sounds> soundlist = null;
		Session session = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Sounds.class);
			criteria.add(Restrictions.eq("soundType", soundType));
			soundlist = criteria.list();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return soundlist;
	}

	public List<Sounds> getSoundByBrand(String soundBrand) {
		List<Sounds> soundlist = null;
		Session session = null;
		try {
			session = factory.openSession();
			Transaction transaction=session.beginTransaction();
			Criteria criteria = session.createCriteria(Sounds.class);
			criteria.add(Restrictions.eq("soundBrand", soundBrand));
			soundlist = criteria.list();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return soundlist;
	}

	public boolean deleteSoundstById(Long soundId) {

		try {
			Session session = factory.openSession();
			Sounds sounds = session.load(Sounds.class, soundId);
			session.delete(sounds);
			session.close();
		} catch (Exception e) {
			EventsMessages.deleteIdMessage();
		}
		return true;
	}

	public boolean deleteSoundByType(String soundType) {
		boolean isDelete = false;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Sounds.class);
			criteria.add(Restrictions.eq("soundType", soundType));
			List<Sounds> sounds=criteria.list();
			for (Sounds sound : sounds) {
				session.delete(sound);
			}
			transaction.commit();
			session.close();
			isDelete = true;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return isDelete;
	}

	public boolean deleteSoundByBrand(String soundBrand) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Sounds.class);
			criteria.add(Restrictions.eq("soundBrand", soundBrand));
			List<Sounds> sounds = criteria.list();
			for (Sounds sound : sounds) {
				session.delete(sound);
			}
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return true;
	}

	public boolean deleteAllSounds(Sounds sounds) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(sounds);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			EventsMessages.errorMessage();
		}
		return false;
	}

	public String updateSoundById(Long soundId, Sounds updateSound) {
		Transaction transaction = null;
		Sounds sounds = null;
		try (Session session = factory.openSession();) {
			transaction = session.beginTransaction();
			sounds = session.get(Sounds.class, soundId);
			if (sounds != null) {
				sounds.setSoundType(updateSound.getSoundType());
				sounds.setSoundBrand(updateSound.getSoundBrand());
				sounds.setSoundQuantity(updateSound.getSoundQuantity());
				sounds.setEvents(updateSound.getEvents());
				session.update(sounds);
				transaction.commit();
				session.close();
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

	public String updateSoundByType(String soundType, Sounds updateSound) {

		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Sounds.class);
			criteria.add(Restrictions.eq("soundType", soundType));
			List<Sounds> sounds = criteria.list();
			if (sounds != null && !sounds.isEmpty()) {
				for (Sounds sound : sounds) {
					sound.setSoundBrand(updateSound.getSoundBrand());
					sound.setSoundQuantity(updateSound.getSoundQuantity());
					sound.setEvents(updateSound.getEvents());
					session.update(sounds);
				}
				transaction.commit();
				return EventsMessages.updatedMessage();
			} else {
				return EventsMessages.errorMessage();
			}

		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		}
		return EventsMessages.errorMessage();

	}

	public Object updateSoundByBrand(String soundBrand, Sounds updateSound) {

		Transaction transaction = null;
		List<Sounds> sound = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Sounds.class);
			criteria.add(Restrictions.eq("soundBrand", soundBrand));
			sound = criteria.list();
			if (sound != null && sound.isEmpty()) {
				for (Sounds sounds : sound) {
					sounds.setSoundType(updateSound.getSoundType());
					sounds.setSoundQuantity(updateSound.getSoundQuantity());
					sounds.setEvents(updateSound.getEvents());
					session.update(sounds);
				}
				transaction.commit();
				session.close();
				return EventsMessages.updatedMessage();
			} else {
				return EventsMessages.errorMessage();
			}

		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		}
		return EventsMessages.errorMessage();
	}

}
