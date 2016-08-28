package test;

import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;

import tool.DateConvernt;

import impl.BookInfoDAOimpl;
import impl.BookTypeDAOimpl;
import dao.IBookInforDAO;
import dao.IBookTypeDAO;
import enetiy.BookInfo;
import enetiy.BookType;
import enetiy.Student;

public class BookInfoDAOimplTest {
	public static void main(String[] args) {
		//testdelete();
		//testfiandAll();
		//testfiandById();
		testsave();
		//testmodify();
		//testGetNowPageData();
		//testGetPageCount();
	}
	public static void testGetPageCount() {
		int pageSize = 2;
		IBookInforDAO bookInforDAO = new BookInfoDAOimpl();
		System.out.println(bookInforDAO.getpageCount(pageSize));
	}
	public static void testGetNowPageData(){
		int nowPage = 2;
		int pageSize = 2;
		IBookInforDAO dao =new BookInfoDAOimpl();
		List<BookInfo> bookInfos =  dao.getnowPageData(pageSize, nowPage);
		for (BookInfo bookInfo : bookInfos) {
			System.out.println(bookInfo);
		}
	}
	public static void testdelete(){
		int bookId =1;
		BookInfo bookInfo = new BookInfo();
		IBookInforDAO dao = new BookInfoDAOimpl();
		System.out.println(dao.delete(bookId)); 
    }
	public static void testfiandAll(){
		IBookInforDAO dao = new BookInfoDAOimpl();
		List<BookInfo> list  = dao.findAll();
		 for (BookInfo bookType : list) {
			System.out.println(bookType);
		}
	}
	public static void testfiandById(){
		int bookId = 25;
		IBookInforDAO dao = new BookInfoDAOimpl();
		BookInfo bookType = dao.findById(bookId );
		System.out.println(bookType);
		
	}
     public static void testmodify(){
	    String btdstr = "1996-7-12";
		Date btd = DateConvernt.ConvertToDate(btdstr);
    	 BookInfo bookType = new BookInfo("ggg", 3, "d", "hh", "hh", "shh", "shs", 52, btd, 253, 2, btd, 2, 1);
		bookType.setBookId(1);
		IBookInforDAO dao = new BookInfoDAOimpl();
		System.out.println(dao.modify(bookType)); 
    }
     public static void testsave(){
 	    String btdstr = "1992-7-12";
 		Date btd = DateConvernt.ConvertToDate(btdstr);
     	 BookInfo bookType = new BookInfo("mmm", 3, "ggd", "mm", "mm", "mm", "mm", 66, btd, 263, 2, btd, 2, 1);
 		IBookInforDAO dao = new BookInfoDAOimpl();
 		System.out.println(dao.save(bookType)); 
     }
}
