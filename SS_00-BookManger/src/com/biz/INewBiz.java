package com.biz;

import java.util.List;

import com.po.New;


public interface INewBiz {
	public boolean save (New new1);
	public boolean delById (int  newsId);
	public boolean update ( New new1);
	public New findById (int newsId);
	public List<New> findAll ();
	public List<New> findFbTime (int rows);
	//��ҳ��
	public int getpageCount(int pageSize);
	//�õ���ǰҳ������
	public List<New> getnowPageData(int pageSize,int nowPage);
	
}
