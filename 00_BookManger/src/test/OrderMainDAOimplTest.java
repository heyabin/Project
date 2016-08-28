package test;

import impl.NewDAOimpl;
import impl.OrderMainDAOimpl;

import java.util.Date;
import java.util.List;

import tool.DateConvernt;
import dao.NewDAO;
import dao.OrderMainDAO;
import enetiy.News;
import enetiy.OrderMain;

public class OrderMainDAOimplTest {
	public static void main(String[] args) {
		//testsave();
    	//testdelete();
    	//testupdate();
    	//testfindById();
    	//testfiandAll();
		//testde();
		teste();
	}
	 public static void testde(){
			 int pageSize = 1;
			OrderMainDAO dao = new OrderMainDAOimpl();
			System.out.println(dao.getpageCount(pageSize)); 
	  }
	  public static void teste(){
		 int pageSize = 1;
		 int nowPage  = 3;
			OrderMainDAO dao = new OrderMainDAOimpl();
		List<OrderMain>	List = dao.getnowPageData(pageSize, nowPage);
		for (OrderMain orderMain : List) {
			System.out.println(orderMain);
		}
		
	  }
	
	 public static void testsave(){
			boolean isDelete = false;
			OrderMain news = new OrderMain("6", 2, "ff", "dd", "d", "d", 2, "d", 2);
			OrderMainDAO dao = new OrderMainDAOimpl();
			System.out.println(dao.save(news)); 
			
	}
	 public static void testdelete(){
			String  orderNum = "6";
			OrderMainDAO dao = new OrderMainDAOimpl();
			System.out.println(dao.delete(orderNum)); 
	  }
	 public static void testupdate(){
		 OrderMain news = new OrderMain(2, "บุ", "dd", "d", "1", 2, "dddddd", 2);
		 news.setOrderNum("5");
		 OrderMainDAO dao = new OrderMainDAOimpl();
		System.out.println(dao.modify(news)); 
	}
	 public static void testfindById(){
			String orderNum = "4";
			 OrderMainDAO dao = new OrderMainDAOimpl();
			 OrderMain orderMain =  dao.findById(orderNum);
			System.out.println(orderMain); 
		}
	 public static void testfiandAll(){
		 OrderMainDAO dao = new OrderMainDAOimpl();
			  List<OrderMain>list = dao.findAll();
			 for (OrderMain orderMain : list) {
				 System.out.println(orderMain);
			}
				
		}
}
