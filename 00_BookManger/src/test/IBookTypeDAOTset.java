package test;

import java.util.List;

import impl.BookInfoDAOimpl;
import impl.BookTypeDAOimpl;
import dao.IBookInforDAO;
import dao.IBookTypeDAO;
import dao.IStudentDAO;
import enetiy.BookInfo;
import enetiy.BookType;
import enetiy.Student;

public class IBookTypeDAOTset {
	public static void main(String[] args) {
	   // testdelete();
		//testfiandAll();
		//testfiandById();
		//testsave();
		//testmodify();
		//testgetcpn();
		testget();
	}
	public static void testget(){
		int nowPage = 2;
		int pageSize = 2;
		IBookTypeDAO bookInfos = new BookTypeDAOimpl();
		List<BookType> list = bookInfos.getnowPageData(nowPage, pageSize);
		for (BookType bookType : list) {
			System.out.println(bookType);
		}
		
	}
	
	public static void testgetcpn(){
		int pageSize = 2;
		IBookTypeDAO dao = new BookTypeDAOimpl();
		System.out.println(dao.getpageCount(pageSize));
    }
	public static void testdelete(){
		int bookTypeId =3;
		//Student stu = new Student();
		IBookTypeDAO dao = new BookTypeDAOimpl();
		System.out.println(dao.delete(bookTypeId)); 
    }
	public static void testfiandAll(){
		IBookTypeDAO dao = new BookTypeDAOimpl();
		List<BookType> list  = dao.findAll();
		 for (BookType bookType : list) {
			System.out.println(bookType);
		}
	}
	public static void testfiandById(){
		int bookTypeId = 1;
		IBookTypeDAO dao = new BookTypeDAOimpl();
		BookType bookType = dao.findById(bookTypeId);
		System.out.println(bookType);
		
	}
	public static void testsave(){
		IBookTypeDAO dao = new BookTypeDAOimpl();
		BookType bookType = new BookType(6, 0, "小说	", "它是通过塑造人物");
		System.out.println(dao.save(bookType)); 
    }
	public static void testmodify(){
		
		BookType bookType = new BookType(2, "ddd", "dddds");
		bookType.setBookTypeId(6);
		IBookTypeDAO dao = new BookTypeDAOimpl();
		System.out.println(dao.modify(bookType)); 
    }
}
