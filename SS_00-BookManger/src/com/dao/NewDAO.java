package com.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.po.New;

/**
 * A data access object (DAO) providing persistence and search support for New
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.po.New
 * @author MyEclipse Persistence Tools
 */
@Service("NewDAO")
public class NewDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(NewDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String CONTEXT = "context";
	public static final String IS_DELETE = "isDelete";

	protected void initDao() {
		// do nothing
	}

	public void save(New transientInstance) {
		log.debug("saving New instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(New persistentInstance) {
		log.debug("deleting New instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public New findById(java.lang.Integer id) {
		log.debug("getting New instance with id: " + id);
		try {
			New instance = (New) getHibernateTemplate().get("com.po.New", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<New> findByExample(New instance) {
		log.debug("finding New instance by example");
		try {
			List<New> results = (List<New>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding New instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from New as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<New> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List<New> findByContext(Object context) {
		return findByProperty(CONTEXT, context);
	}

	public List<New> findByIsDelete(Object isDelete) {
		return findByProperty(IS_DELETE, isDelete);
	}

	public List findAll() {
		log.debug("finding all New instances");
		try {
			String queryString = "from New";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List<New> findFbTime(int rows) {
		String hql = "from com.po.New ";
		Query query = getSession().createQuery(hql);
		query.setMaxResults(rows);
		return query.list();
	}
	public New merge(New detachedInstance) {
		log.debug("merging New instance");
		try {
			New result = (New) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(New instance) {
		log.debug("attaching dirty New instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(New instance) {
		log.debug("attaching clean New instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NewDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NewDAO) ctx.getBean("NewDAO");
	}
}