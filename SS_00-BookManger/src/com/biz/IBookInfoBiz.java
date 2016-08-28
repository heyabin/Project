	package com.biz;

import java.util.List;

import com.po.BookInfo;

public interface IBookInfoBiz {
	public boolean save (BookInfo bookInfo);
	public boolean delById (int bookId);
	public boolean update ( BookInfo bookInfo);
	public BookInfo findById ( int bookId);
	public List<BookInfo> findBybookType (int booktypeId);
	
	//��ҳ��
	public int getpageCount(int pageSize);
	public List<BookInfo> getnowPageData(int pageSize,int nowPage);
	
	public int getpageCount2(int pageSize,int bookTypeId );
	//�õ���ǰҳ������
	
	public List<BookInfo> getnowPageData2(int pageSize,int nowPage,int bookTypeId);
	//�ϼ����ڻ�ȡ������
	public List<BookInfo> findBySjDate (int rows);
	//������������ȡ������
	public List<BookInfo> findBySaleCount (int rows);
	//������������ȡ�Ƽ���
	public List<BookInfo> findAll();
	
	
	
	
}
