package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.po.CustomerDetailInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * CustomerDetailInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.po.CustomerDetailInfo
 * @author MyEclipse Persistence Tools
 */
@Service("CustomerDetailInfoDAO")
public class CustomerDetailInfoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CustomerDetailInfoDAO.class);
	// property constants
	public static final String TEL = "tel";
	public static final String ADDRESS = "address";
	public static final String SEX = "sex";
	public static final String AGE = "age";
	public static final String COUNT_MONEY = "countMoney";
	public static final String QQ = "qq";

	protected void initDao() {
		// do nothing
	}

	public void save(CustomerDetailInfo transientInstance) {
		log.debug("saving CustomerDetailInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CustomerDetailInfo persistentInstance) {
		log.debug("deleting CustomerDetailInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CustomerDetailInfo findById(java.lang.Integer id) {
		log.debug("getting CustomerDetailInfo instance with id: " + id);
		try {
			CustomerDetailInfo instance = (CustomerDetailInfo) getHibernateTemplate()
					.get("com.po.CustomerDetailInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<CustomerDetailInfo> findByExample(CustomerDetailInfo instance) {
		log.debug("finding CustomerDetailInfo instance by example");
		try {
			List<CustomerDetailInfo> results = (List<CustomerDetailInfo>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<CustomerDetailInfo> findAll(int nowPage, int pageSize) {

		String hql = "from  CustomerDetailInfo order by custId";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((nowPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();

	}

	public int findMaxPage(int pageSize) {
		String hql = "select count(*) from CustomerDetailInfo";
		int maxpage = 0;
		int maxrow = 0;
		Query query = getSession().createQuery(hql);
		maxrow = Integer.parseInt(query.list().get(0).toString());
		if (maxrow == 0) {
			maxpage = 1;
		} else {
			maxpage = maxrow % pageSize == 0 ? maxrow / pageSize : maxrow
					/ pageSize + 1;
		}
		return maxpage;
	}

	/********************* ·ÖÒ³ ****************/
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CustomerDetailInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CustomerDetailInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<CustomerDetailInfo> findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List<CustomerDetailInfo> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<CustomerDetailInfo> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List<CustomerDetailInfo> findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List<CustomerDetailInfo> findByCountMoney(Object countMoney) {
		return findByProperty(COUNT_MONEY, countMoney);
	}

	public List<CustomerDetailInfo> findByQq(Object qq) {
		return findByProperty(QQ, qq);
	}

	public List findAll() {
		log.debug("finding all CustomerDetailInfo instances");
		try {
			String queryString = "from CustomerDetailInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CustomerDetailInfo merge(CustomerDetailInfo detachedInstance) {
		log.debug("merging CustomerDetailInfo instance");
		try {
			CustomerDetailInfo result = (CustomerDetailInfo) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CustomerDetailInfo instance) {
		log.debug("attaching dirty CustomerDetailInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CustomerDetailInfo instance) {
		log.debug("attaching clean CustomerDetailInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CustomerDetailInfoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CustomerDetailInfoDAO) ctx.getBean("CustomerDetailInfoDAO");
	}
}