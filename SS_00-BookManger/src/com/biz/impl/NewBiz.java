package com.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.INewBiz;
import com.po.New;
import com.service.dao.DaoService;
@Transactional
@Service("NewBiz")
public class NewBiz implements INewBiz{
	@Resource(name = "DaoService")
	private DaoService daoService;
	public boolean save(New new1) {
		try {
			daoService.getNewDAO().save(new1);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delById(int newsId) {
		try {
			New oldNew = daoService.getNewDAO().findById(newsId);
			daoService.getNewDAO().delete(oldNew);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(New new1) {
		
		try {
			daoService.getNewDAO().merge(new1);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public New findById(int newsId) {
	
		return daoService.getNewDAO().findById(newsId);
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<New> findAll() {
		return daoService.getNewDAO().findAll();
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<New> findFbTime(int rows) {
		
		return daoService.getNewDAO().findFbTime(rows);
	}

	public int getpageCount(int pageSize) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<New> getnowPageData(int pageSize, int nowPage) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
