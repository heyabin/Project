package test;

import impl.BookDiscussDAOimpl;
import impl.FavoriteDAOimpl;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import tool.DateConvernt;
import dao.BookDiscussDAO;
import dao.FavoriteDAO;
import enetiy.BookDiscuss;
import enetiy.Favorite;

public class BookDiscussDAOimplTest {
	public static void main(String[] args) {
		//testdelete();
		//testfiandAll();
		//testfiandById();
		//testsave();
		//testmodify();
		//testde();
		testd();
	}
	
	public static void testd(){
		int pageSize = 3;
		int nowPage = 3;
		BookDiscussDAO dao = new BookDiscussDAOimpl();
		List<BookDiscuss> list = dao.getnowPageDate(pageSize, nowPage); 
		for (BookDiscuss bookDiscuss : list) {
			System.out.println(bookDiscuss);
		}
       
	}
	public static void testde(){
		int  pageSize = 1;
		BookDiscussDAO dao = new BookDiscussDAOimpl();
		System.out.println(dao.getPageCount(pageSize));
	}
	
	public static void testdelete(){
		int  disId = 7;
		BookDiscussDAO dao = new BookDiscussDAOimpl();
		System.out.println(dao.delete(disId));
	}
	public static void testfiandAll(){
	BookDiscussDAO dao = new BookDiscussDAOimpl();
	List<BookDiscuss> list = dao.findAll();
	for (BookDiscuss bookDiscuss : list) {
		System.out.println(bookDiscuss);
	}
	
    }
	public static void testfiandById(){
		int disId  = 11;
		BookDiscussDAO dao = new BookDiscussDAOimpl();
		System.out.println(dao.findById(disId));
	}
	 public static void testmodify(){
	
		 BookDiscussDAO dao = new BookDiscussDAOimpl();
			BookDiscuss bookDiscuss = new BookDiscuss(15,2, 2, "好书", "1");
			dao.modify(bookDiscuss);
	 
	 }
	 public static void testsave(){
			BookDiscussDAO dao = new BookDiscussDAOimpl();
			BookDiscuss bookDiscuss = new BookDiscuss(2, 2, "好书", "1");
			dao.save(bookDiscuss);
	 }
}
