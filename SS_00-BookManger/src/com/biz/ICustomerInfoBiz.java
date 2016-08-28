	package com.biz;

import java.util.List;

import com.po.CustomerInfo;

public interface ICustomerInfoBiz {
	public boolean save (CustomerInfo custId);
	public boolean delById(int custId);
	public boolean update (CustomerInfo customerInfo);
	public CustomerInfo findById ( int custId);
	public List<CustomerInfo> findAll ();
	public int getpageCount(int pageSize);
	public CustomerInfo findNameAndPassword(CustomerInfo customerInfo);
	public List<CustomerInfo> getnowPageData (int pageSize,int nowPage);
	
}
