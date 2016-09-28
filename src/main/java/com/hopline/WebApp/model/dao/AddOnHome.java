package com.hopline.WebApp.model.dao;
// Generated 28 Sep, 2016 12:38:57 AM by Hibernate Tools 5.2.0.Beta1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class AddOn.
 * @see com.hopline.WebApp.model.dao.AddOn
 * @author Hibernate Tools
 */
public class AddOnHome {

	private static final Log log = LogFactory.getLog(AddOnHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(AddOn transientInstance) {
		log.debug("persisting AddOn instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AddOn instance) {
		log.debug("attaching dirty AddOn instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AddOn instance) {
		log.debug("attaching clean AddOn instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AddOn persistentInstance) {
		log.debug("deleting AddOn instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AddOn merge(AddOn detachedInstance) {
		log.debug("merging AddOn instance");
		try {
			AddOn result = (AddOn) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AddOn findById(java.lang.Integer id) {
		log.debug("getting AddOn instance with id: " + id);
		try {
			AddOn instance = (AddOn) sessionFactory.getCurrentSession().get("com.hopline.WebApp.model.dao.AddOn", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AddOn instance) {
		log.debug("finding AddOn instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.hopline.WebApp.model.dao.AddOn")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
