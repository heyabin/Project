package com.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.IBookDiscussBiz;
import com.po.BookDiscuss;
import com.service.dao.DaoService;

@Transactional
@Service("BookDiscussBiz")
public class BookDiscussBiz implements IBookDiscussBiz{
	@Resource(name = "DaoService")
	private DaoService daoService;
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public boolean save(BookDiscuss bookDiscuss) {
		try {
			daoService.getBookDiscussDAO().save(bookDiscuss);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delById(int disId) {
		try {
			BookDiscuss bookDiscuss = daoService.getBookDiscussDAO().findById(disId);
			daoService.getBookDiscussDAO().delete(bookDiscuss);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean update(BookDiscuss bookDiscuss) {
		try {
			daoService.getBookDiscussDAO().merge(bookDiscuss);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		return false;
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public BookDiscuss findById(int disId) {
		// TODO Auto-generated method stub
		return daoService.getBookDiscussDAO().findById(disId);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<BookDiscuss> findAll() {
		// TODO Auto-generated method stub
		return daoService.getBookDiscussDAO().findAll();
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<BookDiscuss> getnowPageDate(int pageSize, int nowPage) {
		if(nowPage<1)nowPage=1;
		if(pageSize<1)pageSize=5;
		return daoService.getBookDiscussDAO().findAll(nowPage, pageSize);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int getPageCount(int pageSize) {
		if(pageSize<1)pageSize=5;
		return daoService.getBookDiscussDAO().findMaxPage(pageSize);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<BookDiscuss> findByBookId(int bookId) {
		return daoService.getBookDiscussDAO().findByBookId(bookId);
	}

	
	
	
}
