package com.dao;



import java.util.List;


import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.po.SysAdmin;

/**
 * A data access object (DAO) providing persistence and search support for
 * SysAdmin entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.po.SysAdmin
 * @author MyEclipse Persistence Tools
 */
@Service("SysAdminDAO")
public class SysAdminDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(SysAdminDAO.class);
	// property constants
	public static final String ADMIN_NAME = "adminName";
	public static final String PWD = "pwd";
	public static final String ADMIN_TYPE = "adminType";

	protected void initDao() {
		// do nothing
	}

	public void save(SysAdmin transientInstance) {
		log.debug("saving SysAdmin instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SysAdmin persistentInstance) {
		log.debug("deleting SysAdmin instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SysAdmin findById(java.lang.Integer id) {
		log.debug("getting SysAdmin instance with id: " + id);
		try {
			SysAdmin instance = (SysAdmin) getHibernateTemplate().get(
					"com.po.SysAdmin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public SysAdmin findNameAndPwd(String name, String pwd) {
		String hql = "from SysAdmin where adminName = ? and pwd = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, name);
		query.setParameter(1, pwd);
		return (SysAdmin) query.list().get(0);
}
	/**
	 * 分页
	 * */
	public List<SysAdmin> findAll(int page,int rows){
	
		String hql="from SysAdmin order by adminId";
		Query query=getSession().createQuery(hql);
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return query.list();
	}
	/**********************************************/
	/**
	 * 获取最大页数
	 * */
	public int findMaxPage(int rows){
		String hql="select count(*) from SysAdmin";
		int maxpage=0;
		int maxrow=0;
		Query query=getSession().createQuery(hql);
				
		
		maxrow=Integer.parseInt(query.list().get(0).toString());
		
		if(maxrow==0){
			maxpage=1;
		}else{
			maxpage=maxrow%rows==0?maxrow/rows:maxrow/rows+1;
		}
		return maxpage;
	}
/**********************************************/	
	public List<SysAdmin> findByExample(SysAdmin instance) {
		log.debug("finding SysAdmin instance by example");
		try {
			List<SysAdmin> results = (List<SysAdmin>) getHibernateTemplate()
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
		log.debug("finding SysAdmin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysAdmin as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<SysAdmin> findByAdminName(Object adminName) {
		return findByProperty(ADMIN_NAME, adminName);
	}

	public List<SysAdmin> findByPwd(Object pwd) {
		return findByProperty(PWD, pwd);
	}

	public List<SysAdmin> findByAdminType(Object adminType) {
		return findByProperty(ADMIN_TYPE, adminType);
	}

	public List findAll() {
		log.debug("finding all SysAdmin instances");
		try {
			String queryString = "from SysAdmin";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SysAdmin merge(SysAdmin detachedInstance) {
		log.debug("merging SysAdmin instance");
		try {
			SysAdmin result = (SysAdmin) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SysAdmin instance) {
		log.debug("attaching dirty SysAdmin instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SysAdmin instance) {
		log.debug("attaching clean SysAdmin instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SysAdminDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SysAdminDAO) ctx.getBean("SysAdminDAO");
	}
}