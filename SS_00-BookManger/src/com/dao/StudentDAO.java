package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.po.Student;

/**
 * A data access object (DAO) providing persistence and search support for
 * Student entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.po.Student
 * @author MyEclipse Persistence Tools
 */
@Service("StudentDAO")
public class StudentDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(StudentDAO.class);
	// property constants
	public static final String STU_NAME = "stuName";
	public static final String STU_AGE = "stuAge";
	public static final String STU_SEX = "stuSex";
	public static final String STU_TEL = "stuTel";
	public static final String IS_DELETE = "isDelete";

	protected void initDao() {
		// do nothing
	}

	public void save(Student transientInstance) {
		log.debug("saving Student instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Student persistentInstance) {
		log.debug("deleting Student instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Student findById(java.lang.Integer id) {
		log.debug("getting Student instance with id: " + id);
		try {
			Student instance = (Student) getHibernateTemplate().get(
					"com.po.Student", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/**
	 * 分页
	 * */
	public List<Student> findAll(int page,int rows){
	
		String hql="from Student order by stuId";
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
		String hql="select count(*) from Student";
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
	public List<Student> findByExample(Student instance) {
		log.debug("finding Student instance by example");
		try {
			List<Student> results = (List<Student>) getHibernateTemplate()
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
		log.debug("finding Student instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Student as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Student> findByStuName(Object stuName) {
		return findByProperty(STU_NAME, stuName);
	}

	public List<Student> findByStuAge(Object stuAge) {
		return findByProperty(STU_AGE, stuAge);
	}

	public List<Student> findByStuSex(Object stuSex) {
		return findByProperty(STU_SEX, stuSex);
	}

	public List<Student> findByStuTel(Object stuTel) {
		return findByProperty(STU_TEL, stuTel);
	}

	public List<Student> findByIsDelete(Object isDelete) {
		return findByProperty(IS_DELETE, isDelete);
	}

	public List findAll() {
		log.debug("finding all Student instances");
		try {
			String queryString = "from Student";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Student merge(Student detachedInstance) {
		log.debug("merging Student instance");
		try {
			Student result = (Student) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Student instance) {
		log.debug("attaching dirty Student instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Student instance) {
		log.debug("attaching clean Student instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StudentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StudentDAO) ctx.getBean("StudentDAO");
	}
}