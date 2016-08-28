package dao;

import java.util.List;

import enetiy.BookDiscuss;


public interface BookDiscussDAO {
	public boolean save (BookDiscuss bookDiscuss);
	public boolean delete (int disId);
	public boolean modify ( BookDiscuss bookDiscuss);
	public List<BookDiscuss>  findById ( int bookId);
	public BookDiscuss  findById2 ( int disId);
	
	public int getPageCount ( int pageSize);
	public List<BookDiscuss> getnowPageDate (int pageSize,int nowPage);
	
	public List<BookDiscuss> findAll ();
}
