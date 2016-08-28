	package dao;

import java.util.List;

import enetiy.BookInfo;
import enetiy.BookType;
import enetiy.Student;

public interface IBookInforDAO {
	public boolean save (BookInfo bookInfo);
	public boolean delete (int bookId);
	public boolean modify ( BookInfo bookInfo);
	public BookInfo findById ( int bookId);
	
	public List<BookInfo> findBybookType (int typeId);
	//总页数
	public int getpageCount(int pageSize);
	public int getpageCount2(int pageSize,int bookTypeId );
	//得到当前页的数据
	public List<BookInfo> getnowPageData(int pageSize,int nowPage);
	public List<BookInfo> getnowPageData2(int pageSize,int nowPage,int bookTypeId);
	//上架日期获取最新书
	public List<BookInfo> findBySjDate (int rows);
	//根据销售量获取热销书
	public List<BookInfo> findBySaleCount (int rows);
	//根据销售量获取推荐书
	public List<BookInfo> findAll();
	
	
	
	
}
