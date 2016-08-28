package com.biz;

import java.sql.Connection;
import java.util.List;

import com.po.OrderMain;

public interface IOrderMainBiz {
	public boolean save (OrderMain orderMain);
	public boolean delById(String orderNum);
	public boolean update ( OrderMain orderMain);
	public OrderMain findById (String orderNum);
	public List<OrderMain> findAll ();
	public int getpageCount(int pageSize);
    public 	List<OrderMain> getnowPageData(int pageSize,int nowPage);
	
	public boolean save (Connection newcon ,OrderMain orderMain);
}

