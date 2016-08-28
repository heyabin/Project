package com.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.po.OrderMain;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrderMain entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.po.OrderMain
 * @author MyEclipse Persistence Tools
 */
@Service("OrderMainDAO")
public class OrderMainDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(OrderMainDAO.class);
	// property constants
	public static final String CUSTOMER_NAME = "customerName";
	public static final String TEL = "tel";
	public static final String ADDRESS = "address";
	public static final String STATUS = "status";
	public static final String CONTEXT = "context";
	public static final String SUMPRICE = "sumprice";

	protected void initDao() {
		// do nothing
	}

	public void save(OrderMain transientInstance) {
		log.debug("saving OrderMain instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OrderMain persistentInstance) {
		log.debug("deleting OrderMain instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrderMain findById(java.lang.String id) {
		log.debug("getting OrderMain instance with id: " + id);
		try {
			OrderMain instance = (OrderMain) getHibernateTemplate().get(
					"com.po.OrderMain", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<OrderMain> findByExample(OrderMain instance) {
		log.debug("finding OrderMain instance by example");
		try {
			List<OrderMain> results = (List<OrderMain>) getHibernateTemplate()
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
		log.debug("finding OrderMain instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from OrderMain as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<OrderMain> findByCustomerName(Object customerName) {
		return findByProperty(CUSTOMER_NAME, customerName);
	}

	public List<OrderMain> findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List<OrderMain> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<OrderMain> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<OrderMain> findByContext(Object context) {
		return findByProperty(CONTEXT, context);
	}

	public List<OrderMain> findBySumprice(Object sumprice) {
		return findByProperty(SUMPRICE, sumprice);
	}

	public List findAll() {
		log.debug("finding all OrderMain instances");
		try {
			String queryString = "from OrderMain";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * ��ҳ
	 */
	public List<OrderMain> findAll(int nowPage,int pageSize) {
		String hql = "from OrderMain where 1=1";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((nowPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	/**
	 * �õ����ҳ
	 */
	public int findMaxCount(int pageSize) {
		int rowCount = 0;
		int pageCount = 0;
		String hql = "select count(*) from OrderMain where 1=1";
		Query query = getSession().createQuery(hql);
		rowCount = Integer.parseInt(query.list().get(0).toString());
		if (rowCount <= 1) {
			pageCount = 1;
		}else {
			pageCount = rowCount % pageSize == 0 ? rowCount / pageSize : rowCount / pageSize + 1;
		}
		return pageCount;
		
	}
	public OrderMain merge(OrderMain detachedInstance) {
		log.debug("merging OrderMain instance");
		try {
			OrderMain result = (OrderMain) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OrderMain instance) {
		log.debug("attaching dirty OrderMain instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrderMain instance) {
		log.debug("attaching clean OrderMain instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OrderMainDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OrderMainDAO) ctx.getBean("OrderMainDAO");
	}
}