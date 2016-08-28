package com.biz;

import java.util.List;

import com.po.BookDiscuss;

public interface IBookDiscussBiz {
	public boolean save (BookDiscuss bookDiscuss);
	public boolean delById (int disId);
	public boolean update ( BookDiscuss bookDiscuss);
	public BookDiscuss  findById ( int disId);
	public List<BookDiscuss> findAll ();
	public List<BookDiscuss>  findByBookId ( int disId);
	public int getPageCount ( int pageSize);
	public List<BookDiscuss> getnowPageDate (int pageSize,int nowPage);
	
}
