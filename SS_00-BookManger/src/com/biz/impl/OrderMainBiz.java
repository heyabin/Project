package com.biz.impl;

import java.sql.Connection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.IOrderMainBiz;
import com.po.OrderMain;
import com.service.biz.BizService;
import com.service.dao.DaoService;
@Transactional
@Service("OrderMainBiz")
public class OrderMainBiz implements IOrderMainBiz{
	@Resource(name = "DaoService")
	private DaoService daoService;
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public boolean save(OrderMain orderMain) {
			try {
				daoService.getOrderMainDAO().save(orderMain);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}

	public boolean delById(String orderNum) {
		try {
		OrderMain orderMain = 	daoService.getOrderMainDAO().findById(orderNum);
		daoService.getOrderMainDAO().delete(orderMain);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return false;
	}

	public boolean update(OrderMain orderMain) {
		try {
			daoService.getOrderMainDAO().merge(orderMain);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public OrderMain findById(String orderNum) {

		return daoService.getOrderMainDAO().findById(orderNum);
	}
@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OrderMain> findAll() {

		return daoService.getOrderMainDAO().findAll();
	}
@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int getpageCount(int pageSize) {
		
		return daoService.getOrderMainDAO().findMaxCount(pageSize);
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OrderMain> getnowPageData(int pageSize, int nowPage) {
		
		return daoService.getOrderMainDAO().findAll(nowPage, pageSize);
	}

	public boolean save(Connection newcon, OrderMain orderMain) {
		// TODO Auto-generated method stub
		return false;
	}

}
