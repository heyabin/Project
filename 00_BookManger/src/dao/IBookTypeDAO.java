package dao;

import java.util.List;

import enetiy.BookInfo;
import enetiy.BookType;
import enetiy.Student;

public interface IBookTypeDAO {
	public boolean save (BookType bookType);
	public boolean delete (int bookTypeId);
	public boolean modify ( BookType bookType);
	public BookType findById ( int bookTypeId);
	public int getpageCount(int pageSize);
	//得到当前页的数据
	public List<BookType> getnowPageData(int pageSize,int nowPage);
	public List<BookType> findByParentId(int parentId);
	public List<BookType> findAll ();
	
}
