package dao;

import java.sql.Connection;
import java.util.List;

import enetiy.OrderDetail;
import enetiy.OrderMain;

public interface OrderDetailDAO {
	public boolean save(OrderDetail orderDetail);
	public boolean save(List<OrderDetail> orderDetails);
	public boolean save(Connection connew,List<OrderDetail> orderDetails);
	public boolean modify(OrderDetail orderDetail);
	public boolean delete(int detailId);
	
	public int  getpageCount(int pageSize);
	public List<OrderDetail> getnowPageDate(int pageSize,int nowPage);
	public OrderDetail  findByDetailId(int detailId);
	public List<OrderDetail> findAll();
	
	
	
	
}
