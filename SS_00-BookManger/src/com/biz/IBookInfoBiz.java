	package com.biz;

import java.util.List;

import com.po.BookInfo;

public interface IBookInfoBiz {
	public boolean save (BookInfo bookInfo);
	public boolean delById (int bookId);
	public boolean update ( BookInfo bookInfo);
	public BookInfo findById ( int bookId);
	public List<BookInfo> findBybookType (int booktypeId);
	
	//总页数
	public int getpageCount(int pageSize);
	public List<BookInfo> getnowPageData(int pageSize,int nowPage);
	
	public int getpageCount2(int pageSize,int bookTypeId );
	//得到当前页的数据
	
	public List<BookInfo> getnowPageData2(int pageSize,int nowPage,int bookTypeId);
	//上架日期获取最新书
	public List<BookInfo> findBySjDate (int rows);
	//根据销售量获取热销书
	public List<BookInfo> findBySaleCount (int rows);
	//根据销售量获取推荐书
	public List<BookInfo> findAll();
	
	
	
	
}
