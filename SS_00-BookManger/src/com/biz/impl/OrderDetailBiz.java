package com.biz.impl;

import java.sql.Connection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.IOrderDetailBiz;
import com.po.OrderDetail;
import com.service.dao.DaoService;

@Transactional
@Service("OrderDetailBiz")
public class OrderDetailBiz implements IOrderDetailBiz{
	@Resource(name = "DaoService")
	private DaoService daoService;
	
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public boolean save(OrderDetail orderDetail) {
		try {
			daoService.getOrderDetailDAO().save(orderDetail);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return false;
	}

	public boolean update(OrderDetail orderDetail) {
			try {
				daoService.getOrderDetailDAO().merge(orderDetail);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}

	public boolean delById(int detailId) {
		try {
		OrderDetail orderDetail =daoService.getOrderDetailDAO().findById(detailId);
		daoService.getOrderDetailDAO().delete(orderDetail);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public OrderDetail findByDetailId(int detailId) {

		return daoService.getOrderDetailDAO().findById(detailId);
	}
@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OrderDetail> findAll() {

	return daoService.getOrderDetailDAO().findAll();
	}

	public boolean save(Connection connew, List<OrderDetail> orderDetails) {
		return false;
	}

	public int getpageCount(int pageSize) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<OrderDetail> getnowPageDate(int pageSize, int nowPage) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean save(List<OrderDetail> orderDetails) {
		// TODO Auto-generated method stub
		return false;
	}

}
