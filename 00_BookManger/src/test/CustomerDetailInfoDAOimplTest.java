
package test;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import impl.BookTypeDAOimpl;
import impl.CustomerDetailInfoDAOimpl;
import impl.CustomerInfoimpl;
import dao.CustomerDetailInfoDAO;
import dao.CustomerInfoDAO;
import dao.IBookTypeDAO;
import dbutil.DButil;
import enetiy.BookType;
import enetiy.CustomerDetailInfo;
import enetiy.CustomerInfo;

public class CustomerDetailInfoDAOimplTest {
	public static void main(String[] args) {
		//testdelete();
		//testfiandAll();
		//testfiandById();
		//testsave();
		//testmodify();
		//testde();
		 testd();
	}
	public static void testde(){
		int nowPage = 1;
		int pageSize = 3;
		CustomerDetailInfoDAO dao = new CustomerDetailInfoDAOimpl();
		List<CustomerDetailInfo> list = dao.getnowPageData(pageSize, nowPage);
		for (CustomerDetailInfo bookType : list) {
			System.out.println(bookType);
	    }
	}
	public static void testd(){
		int pageSize = 1;
		CustomerDetailInfoDAO dao = new CustomerDetailInfoDAOimpl();
		System.out.println(dao.getpageCount(pageSize));
	}
	public static void testdelete(){
		int custId =1;
		CustomerDetailInfo customerInfo = new CustomerDetailInfo();
		CustomerDetailInfoDAO dao = new CustomerDetailInfoDAOimpl(); 
		System.out.println(dao.delete(custId)); 
	}
	public static void testfiandAll(){
		CustomerDetailInfoDAO dao = new CustomerDetailInfoDAOimpl();
		List<CustomerDetailInfo> list  = dao.findAll();
		 for (CustomerDetailInfo customerDetailInfo : list) {
			 System.out.println(customerDetailInfo);
		}
	}
	public static void testfiandById(){
		int custId =2;
		CustomerDetailInfoDAO dao = new CustomerDetailInfoDAOimpl();
		CustomerDetailInfo bookType = dao.findById(custId);
		System.out.println(bookType);
		
	}
	 public static void testsave(){
		 	CustomerDetailInfo customerInfo = new CustomerDetailInfo(9,"15844444444", " È", 1, 20, 4, 5);
		 	CustomerDetailInfoDAO dao = new CustomerDetailInfoDAOimpl();
		 	System.out.println(dao.save(customerInfo)); 
	 }
	 public static void testmodify(){
		 CustomerDetailInfo bookType = new CustomerDetailInfo(2, "138456983333","µ√µΩ", 1, 21, 4, 5);
		CustomerDetailInfoDAO dao = new CustomerDetailInfoDAOimpl();
			System.out.println(dao.modify(bookType)); 
	    }
}
