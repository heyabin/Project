package com.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.IBookTypeBiz;
import com.po.BookType;
import com.service.dao.DaoService;
@Transactional
@Service("BookTypeBiz")
public class BookTypeBiz implements IBookTypeBiz{
	@Resource(name = "DaoService")
	private DaoService daoService;
	
	public DaoService getDaoService() {
		return daoService;
	}
	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public boolean save(BookType bookType) {
			try {
				daoService.getBookTypeDAO().save(bookType);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}

	public boolean delById(int bookTypeId) {
			try {
			BookType bookType= 	daoService.getBookTypeDAO().findById(bookTypeId);
			daoService.getBookTypeDAO().delete(bookType);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}

	public boolean update(BookType bookType) {
			try {
				daoService.getBookTypeDAO().merge(bookType);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public BookType findById(int bookTypeId) {
		return daoService.getBookTypeDAO().findById(bookTypeId);
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<BookType> findAll() {
		return daoService.getBookTypeDAO().findAll();
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<BookType> getnowPageData(int nowPage, int pageSize) {
		if(nowPage<1)nowPage=1;
		if(pageSize<1)pageSize=5;
		return daoService.getBookTypeDAO().findAll(nowPage, pageSize);
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int getpageCount(int pageSize) {
		if(pageSize<1)pageSize=5;
		return daoService.getBookTypeDAO().findMaxPage(pageSize);
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<BookType> findByParentId(int parentId) {
		return daoService.getBookTypeDAO().findByParentId(parentId);
	}

}
