package com.biz;

import java.sql.Connection;
import java.util.List;

import com.po.OrderDetail;


public interface IOrderDetailBiz {
	public boolean save(OrderDetail orderDetail);
	public boolean update(OrderDetail orderDetail);
	public boolean delById(int detailId);
	public OrderDetail  findByDetailId(int detailId);
	public List<OrderDetail> findAll();
	public boolean save(Connection connew,List<OrderDetail> orderDetails);
	public int  getpageCount(int pageSize);
	public List<OrderDetail> getnowPageDate(int pageSize,int nowPage);
	
	public boolean save(List<OrderDetail> orderDetails);
	
	
	
	
}
