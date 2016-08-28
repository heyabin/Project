package com.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.IStudentBiz;
import com.po.Student;
import com.service.dao.DaoService;

@Transactional
@Service("StudentBiz")
public class StudentBiz implements IStudentBiz{
	@Resource(name = "DaoService")
	private DaoService daoService;
	
	public boolean save(Student student) {
		try {
			daoService.getStudentDAO().save(student);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delById(int stuId) {
		Student oldStudent = daoService.getStudentDAO().findById(stuId);
		try {
			daoService.getStudentDAO().delete(oldStudent);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean update(Student student) {
		try {
			daoService.getStudentDAO().merge(student);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Student findById(int stuId) {
		return daoService.getStudentDAO().findById(stuId);
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Student> findAll() {
		
		return daoService.getStudentDAO().findAll();
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int getpageCount(int pageSize) {
	
		if(pageSize<1)pageSize=5;
		return daoService.getStudentDAO().findMaxPage(pageSize);
	}
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Student> getnowPageData(int pageSize, int nowPage) {
		if(nowPage<1)nowPage=1;
		if(pageSize<1)pageSize=5;
		return daoService.getStudentDAO().findAll(nowPage, pageSize);
	}

	

	
	
}
