package com.biz;

import java.util.List;

import com.po.CustomerDetailInfo;

public interface ICustomerDetailInfoBiz {
	public boolean save (CustomerDetailInfo customerDetailInfo);
	public boolean delById(int custId);
	public boolean update (CustomerDetailInfo customerDetailInfo);
	public CustomerDetailInfo findById (int custId);
	public List<CustomerDetailInfo> findAll ();
	
	//总页数
	public int getpageCount(int pageSize);
	//得到当前页的数据
	public List<CustomerDetailInfo> getnowPageData(int pageSize,int nowPage);
	
	
}
