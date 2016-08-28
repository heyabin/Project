	package dao;

import java.util.List;

import enetiy.CustomerInfo;


public interface CustomerInfoDAO {
	public boolean save (CustomerInfo custId);
	public boolean delete (int customerInfo);
	public boolean modify ( CustomerInfo customerInfo);
	public CustomerInfo findById ( int custId);
	public int getpageCount(int pageSize);
	public CustomerInfo findNameAndPassword(String name, String password);
	public List<CustomerInfo> getnowPageData (int pageSize,int nowPage);
	public List<CustomerInfo> findAll ();
}
