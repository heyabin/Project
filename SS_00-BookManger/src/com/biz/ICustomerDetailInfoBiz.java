package com.biz;

import java.util.List;

import com.po.CustomerDetailInfo;

public interface ICustomerDetailInfoBiz {
	public boolean save (CustomerDetailInfo customerDetailInfo);
	public boolean delById(int custId);
	public boolean update (CustomerDetailInfo customerDetailInfo);
	public CustomerDetailInfo findById (int custId);
	public List<CustomerDetailInfo> findAll ();
	
	//��ҳ��
	public int getpageCount(int pageSize);
	//�õ���ǰҳ������
	public List<CustomerDetailInfo> getnowPageData(int pageSize,int nowPage);
	
	
}
