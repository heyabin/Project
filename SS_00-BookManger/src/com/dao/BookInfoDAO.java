package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.po.BookInfo;
import com.po.BookType;

/**
 * A data access object (DAO) providing persistence and search support for
 * BookInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.po.BookInfo
 * @author MyEclipse Persistence Tools
 */
@Service("BookInfoDAO")
public class BookInfoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(BookInfoDAO.class);
	// property constants
	public static final String BOOK_NAME = "bookName";
	public static final String AUTHOR = "author";
	public static final String PB_NAME = "pbName";
	public static final String CONTEXT = "context";
	public static final String SMALL_IMG = "smallImg";
	public static final String BIG_IMG = "bigImg";
	public static final String PRICE = "price";
	public static final String HYPRICE = "hyprice";
	public static final String BOOK_STATES = "bookStates";
	public static final String NUM = "num";
	public static final String SALE_COUNT = "saleCount";

	protected void initDao() {
		// do nothing
	}

	public void save(BookInfo transientInstance) {
		log.debug("saving BookInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BookInfo persistentInstance) {
		log.debug("deleting BookInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BookInfo findById(java.lang.Integer id) {
		log.debug("getting BookInfo instance with id: " + id);
		try {
			BookInfo instance = (BookInfo) getHibernateTemplate().get(
					"com.po.BookInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BookInfo> findByExample(BookInfo instance) {
		log.debug("finding BookInfo instance by example");
		try {
			List<BookInfo> results = (List<BookInfo>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	/*********************分页****************/
	public List<BookInfo> findAll(int nowPage,int pageSize){
		
		String hql="from  BookInfo order by bookId";
		Query query = getSession().createQuery(hql);
			query.setFirstResult((nowPage-1)*pageSize);
			query.setMaxResults(pageSize);
			return query.list();
		
	}
	
	public int findMaxPage(int pageSize){
		String hql = "select count(*) from BookInfo";
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
	
	/*********************分页****************/
	public List<BookInfo> findBySjDate(int rows) {
		String hql = "from com.po.BookInfo where bookStates = 1 order by  sjdate desc";
		Query query = getSession().createQuery(hql);
		query.setMaxResults(rows);
		return query.list();
	}
	public List<BookInfo> findBySaleCount(int rows) {
		String hql = "from com.po.BookInfo where bookStates = 1 order by  saleCount desc ";
		Query query = getSession().createQuery(hql);
		query.setMaxResults(rows);
		return query.list();
	}
	//根据编号进行分页
	public List<BookInfo> getnowPageData2(int pageSize,int nowPage,int  bookTypeId){
		String hql = "from BookInfo where bookTypeId = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, bookTypeId);
		query.setFirstResult((nowPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	/**
	 * 根据编号得到最大页数
	 */
	public int findMaxCount(int pageSize,Integer bookTypeId){
		int maxpage=0;
		int maxrow = 0;
		String hql = "select count(*) from BookInfo where bookTypeId = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, bookTypeId);
		maxrow = Integer.parseInt(query.list().get(0).toString());
		if (maxrow==0) {
			maxpage = 1;
		}else {
			maxpage =maxrow%pageSize==0?maxrow/pageSize:maxrow/pageSize+1;
		}
		return maxpage;
	}
	/***********************************************************/
	
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BookInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BookInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BookInfo> findByBookName(Object bookName) {
		return findByProperty(BOOK_NAME, bookName);
	}

	public List<BookInfo> findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	public List<BookInfo> findByPbName(Object pbName) {
		return findByProperty(PB_NAME, pbName);
	}

	public List<BookInfo> findByContext(Object context) {
		return findByProperty(CONTEXT, context);
	}

	public List<BookInfo> findBySmallImg(Object smallImg) {
		return findByProperty(SMALL_IMG, smallImg);
	}

	public List<BookInfo> findByBigImg(Object bigImg) {
		return findByProperty(BIG_IMG, bigImg);
	}

	public List<BookInfo> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List<BookInfo> findByHyprice(Object hyprice) {
		return findByProperty(HYPRICE, hyprice);
	}

	public List<BookInfo> findByBookStates(Object bookStates) {
		return findByProperty(BOOK_STATES, bookStates);
	}

	public List<BookInfo> findByNum(Object num) {
		return findByProperty(NUM, num);
	}

	public List<BookInfo> findBySaleCount(Object saleCount) {
		return findByProperty(SALE_COUNT, saleCount);
	}

	public List findAll() {
		log.debug("finding all BookInfo instances");
		try {
			String queryString = "from BookInfo ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BookInfo merge(BookInfo detachedInstance) {
		log.debug("merging BookInfo instance");
		try {
			BookInfo result = (BookInfo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BookInfo instance) {
		log.debug("attaching dirty BookInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BookInfo instance) {
		log.debug("attaching clean BookInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BookInfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BookInfoDAO) ctx.getBean("BookInfoDAO");
	}
}