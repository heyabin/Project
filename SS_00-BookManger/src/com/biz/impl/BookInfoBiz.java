package com.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.IBookInfoBiz;
import com.po.BookInfo;
import com.po.BookType;
import com.service.dao.DaoService;

@Transactional
@Service("BookInfoBiz")
public class BookInfoBiz implements IBookInfoBiz {
	@Resource(name = "DaoService")
	private DaoService daoService;

	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public boolean save(BookInfo bookInfo) {
		try {
			daoService.getBookInfoDAO().save(bookInfo);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean delById(int bookId) {

		try {
			BookInfo bookInfo = daoService.getBookInfoDAO().findById(bookId);
			daoService.getBookInfoDAO().delete(bookInfo);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(BookInfo bookInfo) {

		try {
			daoService.getBookInfoDAO().merge(bookInfo);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public BookInfo findById(int bookId) {
		return daoService.getBookInfoDAO().findById(bookId);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<BookInfo> findAll() {
		// TODO Auto-generated method stub
		return daoService.getBookInfoDAO().findAll();
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<BookInfo> findBySjDate(int rows) {

		return daoService.getBookInfoDAO().findBySjDate(rows);
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<BookInfo> findBySaleCount(int rows) {
		
		return daoService.getBookInfoDAO().findBySaleCount(rows);
	}


	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int getpageCount(int pageSize) {
		if (pageSize < 1)
			pageSize = 5;
		return daoService.getBookInfoDAO().findMaxPage(pageSize);
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int getpageCount2(int pageSize, int bookTypeId) {
		return daoService.getBookInfoDAO().findMaxCount(pageSize, bookTypeId);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<BookInfo> getnowPageData(int pageSize, int nowPage) {
		if (nowPage < 1)
			nowPage = 1;
		if (pageSize < 1)
			pageSize = 5;
		return daoService.getBookInfoDAO().findAll(nowPage, pageSize);

	}

	public List<BookInfo> findBybookType(int booktypeId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<BookInfo> getnowPageData2(int pageSize, int nowPage,int bookTypeId) {
		return daoService.getBookInfoDAO().getnowPageData2(pageSize, nowPage, bookTypeId);
	}

}
