package com.hopline.WebApp.model.dao;
// Generated 4 Oct, 2016 1:44:13 AM by Hibernate Tools 5.2.0.Beta1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class SercurityToken.
 * @see com.hopline.WebApp.model.dao.SecurityToken
 * @author Hibernate Tools
 */
public class SercurityTokenHome {

	private static final Log log = LogFactory.getLog(SercurityTokenHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(SecurityToken transientInstance) {
		log.debug("persisting SercurityToken instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SecurityToken instance) {
		log.debug("attaching dirty SercurityToken instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SecurityToken instance) {
		log.debug("attaching clean SercurityToken instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SecurityToken persistentInstance) {
		log.debug("deleting SercurityToken instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SecurityToken merge(SecurityToken detachedInstance) {
		log.debug("merging SercurityToken instance");
		try {
			SecurityToken result = (SecurityToken) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SecurityToken findById(int id) {
		log.debug("getting SercurityToken instance with id: " + id);
		try {
			SecurityToken instance = (SecurityToken) sessionFactory.getCurrentSession()
					.get("com.hopline.WebApp.model.dao.SercurityToken", id);
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

	public List findByExample(SecurityToken instance) {
		log.debug("finding SercurityToken instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.hopline.WebApp.model.dao.SercurityToken").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
