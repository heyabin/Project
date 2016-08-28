package test;

import java.util.Date;
import java.util.List;

import tool.DateConvernt;

import impl.BookInfoDAOimpl;
import impl.CustomerInfoimpl;
import dao.CustomerInfoDAO;
import dao.IBookInforDAO;
import enetiy.BookInfo;
import enetiy.CustomerInfo;

public class CustomerInfoDAOimplTest {
	public static void main(String[] args) {
		//testdelete();
		//testfiandAll();
		//testfiandById();
		//testsave();
		//testmodify();
		//testde();
		//testd();
	}
	public static void testd(){
		int  pageSize =1;
		CustomerInfoDAO dao = new CustomerInfoimpl(); 
		System.out.println(dao.getpageCount(pageSize)); 
	}
	public static void testde(){
		int pageSize =2;
		int nowPage = 2;
		CustomerInfoDAO dao = new CustomerInfoimpl();
		List<CustomerInfo>list = dao.getnowPageData(pageSize, nowPage);
		for (CustomerInfo customerInfo : list) {
			System.out.println(customerInfo);
		}
	}
	public static void testdelete(){
		int custId =5;
		CustomerInfo customerInfo = new CustomerInfo();
		CustomerInfoDAO dao = new CustomerInfoimpl(); 
		System.out.println(dao.delete(custId)); 
	}
	public static void testfiandAll(){
		CustomerInfoDAO dao = new CustomerInfoimpl();
		List<CustomerInfo> list  = dao.findAll();
		 for (CustomerInfo customerInfo : list) {
			 System.out.println(customerInfo);	
		}
			
    }
	public static void testfiandById(){
		int custId = 9;
		CustomerInfoDAO dao = new CustomerInfoimpl();
		CustomerInfo bookType = dao.findById(custId );
		System.out.println(bookType);
		
	}
	 public static void testmodify(){
	//	 CustomerInfo bookType = new CustomerInfo("党于磊", "123456", "766544@qq.com");
	  CustomerInfo customerInfo = new CustomerInfo(2, "党于磊", "56", "766544@qq.com");
			CustomerInfoDAO dao = new CustomerInfoimpl();
			System.out.println(dao.modify(customerInfo)); 
	    }
	 public static void testsave(){
		 	CustomerInfo customerInfo = new CustomerInfo(9, "FFF", "dddd", "11111@qq.com");
	     	CustomerInfoDAO dao = new CustomerInfoimpl();
	 		System.out.println(dao.save(customerInfo)); 
	     }
}