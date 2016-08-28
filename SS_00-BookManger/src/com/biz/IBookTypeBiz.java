package com.biz;

import java.util.List;

import com.po.BookType;

public interface IBookTypeBiz {
	public boolean save (BookType bookType);
	public boolean delById (int bookTypeId);
	public boolean update ( BookType bookType);
	public BookType findById ( int bookTypeId);
	public List<BookType> findAll ();
	public int getpageCount(int pageSize);
	//得到当前页的数据
	public List<BookType> getnowPageData(int nowPage,int pageSize);
	public List<BookType> findByParentId(int parentId);
	
	
}
