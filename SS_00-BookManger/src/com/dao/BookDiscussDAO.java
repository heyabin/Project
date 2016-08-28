package com.dao;


import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.po.BookDiscuss;

/**
 * A data access object (DAO) providing persistence and search support for
 * BookDiscuss entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.po.BookDiscuss
 * @author MyEclipse Persistence Tools
 */
@Service("BookDiscussDAO")
public class BookDiscussDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(BookDiscussDAO.class);
	// property constants
	public static final String CONTEXT = "context";
	public static final String STATES = "states";

	protected void initDao() {
		// do nothing
	}

	public void save(BookDiscuss transientInstance) {
		log.debug("saving BookDiscuss instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BookDiscuss persistentInstance) {
		log.debug("deleting BookDiscuss instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BookDiscuss findById(java.lang.Integer id) {
		log.debug("getting BookDiscuss instance with id: " + id);
		try {
			BookDiscuss instance = (BookDiscuss) getHibernateTemplate().get(
					"com.po.BookDiscuss", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/**
	 * 分页
	 * */
	public List<BookDiscuss> findAll(int page,int rows){
	
		String hql="from BookDiscuss order by disId";
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
		String hql="select count(*) from BookDiscuss";
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
	
	
	
	public List<BookDiscuss> findByBookId(int bookId){
		String hql="from BookDiscuss where bookId = ? and states = 1";
		Query query=getSession().createQuery(hql);
		query.setParameter(0,bookId);
		return query.list();
	}
/**********************************************/	
	
	public List<BookDiscuss> findByExample(BookDiscuss instance) {
		log.debug("finding BookDiscuss instance by example");
		try {
			List<BookDiscuss> results = (List<BookDiscuss>) getHibernateTemplate()
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
		log.debug("finding BookDiscuss instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BookDiscuss as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BookDiscuss> findByContext(Object context) {
		return findByProperty(CONTEXT, context);
	}

	public List<BookDiscuss> findByStates(Object states) {
		return findByProperty(STATES, states);
	}

	public List findAll() {
		log.debug("finding all BookDiscuss instances");
		try {
			String queryString = "from BookDiscuss";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BookDiscuss merge(BookDiscuss detachedInstance) {
		log.debug("merging BookDiscuss instance");
		try {
			BookDiscuss result = (BookDiscuss) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BookDiscuss instance) {
		log.debug("attaching dirty BookDiscuss instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BookDiscuss instance) {
		log.debug("attaching clean BookDiscuss instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BookDiscussDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (BookDiscussDAO) ctx.getBean("BookDiscussDAO");
	}
}