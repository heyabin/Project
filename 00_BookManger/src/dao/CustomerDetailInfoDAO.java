package dao;

import java.util.List;

import enetiy.BookInfo;
import enetiy.CustomerDetailInfo;

public interface CustomerDetailInfoDAO {
	public boolean save (CustomerDetailInfo customerDetailInfo);
	public boolean delete (int custId);
	public boolean modify ( CustomerDetailInfo customerDetailInfo);
	public CustomerDetailInfo findById ( int custId);
	//��ҳ��
	public int getpageCount(int pageSize);
	//�õ���ǰҳ������
	public List<CustomerDetailInfo> getnowPageData(int pageSize,int nowPage);
	
	public List<CustomerDetailInfo> findAll ();
}
