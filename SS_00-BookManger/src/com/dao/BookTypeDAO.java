package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.po.BookType;

/**
 * A data access object (DAO) providing persistence and search support for
 * BookType entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.po.BookType
 * @author MyEclipse Persistence Tools
 */
@Service("BookTypeDAO")
public class BookTypeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(BookTypeDAO.class);
	// property constants
	public static final String PARENT_ID = "parentId";
	public static final String BOOK_TYPE_NAME = "bookTypeName";
	public static final String CONTEXT = "context";
	public static final String IS_DELETE = "isDelete";

	protected void initDao() {
		// do nothing
	}

	public void save(BookType transientInstance) {
		log.debug("saving BookType instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BookType persistentInstance) {
		log.debug("deleting BookType instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BookType findById(java.lang.Integer id) {
		log.debug("getting BookType instance with id: " + id);
		try {
			BookType instance = (BookType) getHibernateTemplate().get(
					"com.po.BookType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/*********************·ÖÒ³****************/
	public List<BookType> findAll(int nowPage,int pageSize){
		
		String hql="from  BookType ";
		Query query = getSession().createQuery(hql);
			query.setFirstResult((nowPage-1)*pageSize);
			query.setMaxResults(pageSize);
			return query.list();
		
	}
	
	public int findMaxPage(int pageSize){
		String hql = "select count(*) from BookType";
		int maxpage=0;
		int maxrow = 0;
		Query query = getSession().createQuery(hql);
		maxrow = Integer.parseInt(query.list().get(0).toString());
		if (maxrow==0) {
			maxpage = 1;
		}else {
			maxpage =maxrow%pageSize==0?maxrow/pageSize:maxrow/pageSize+1;
		}
		return maxpage;
	}
	public List<BookType> findByParentId(int parentId){
		
		String hql = "from BookType where parentId = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, parentId);
		return query.list();
	}
	/********************************/
	public List<BookType> findByExample(BookType instance) {
		log.debug("finding BookType instance by example");
		try {
			List<BookType> results = (List<BookType>) getHibernateTemplate()
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
		log.debug("finding BookType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BookType as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BookType> findByParentId(Object parentId) {
		return findByProperty(PARENT_ID, parentId);
	}

	public List<BookType> findByBookTypeName(Object bookTypeName) {
		return findByProperty(BOOK_TYPE_NAME, bookTypeName);
	}

	public List<BookType> findByContext(Object context) {
		return findByProperty(CONTEXT, context);
	}

	public List<BookType> findByIsDelete(Object isDelete) {
		return findByProperty(IS_DELETE, isDelete);
	}

	public List findAll() {
		log.debug("finding all BookType instances");
		try {
			String queryString = "from BookType";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BookType merge(BookType detachedInstance) {
		log.debug("merging BookType instance");
		try {
			BookType result = (BookType) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BookType instance) {
		log.debug("attaching dirty BookType instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BookType instance) {
		log.debug("attaching clean BookType instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BookTypeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BookTypeDAO) ctx.getBean("BookTypeDAO");
	}
}