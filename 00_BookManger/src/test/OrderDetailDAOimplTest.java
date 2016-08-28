package test;

import java.util.List;

import impl.OrderDetailDAOimpl;
import dao.OrderDetailDAO;
import enetiy.OrderDetail;

public class OrderDetailDAOimplTest {
	public static void main(String[] args) {
		//testsave();
		//testmodify();
		//testfindAll();
		//testfindById();
		//testdelete();
		//testdele();
		testde();
	}
	public static void  testdele(){
        int pageSize = 1;
		OrderDetailDAO dao = new OrderDetailDAOimpl();
		   System.out.println(dao.getpageCount(pageSize)); 
	}
	public static void  testde(){
        int pageSize = 3;
        int nowPage = 3;
        OrderDetailDAO dao = new OrderDetailDAOimpl();
        List<OrderDetail> list = dao.getnowPageDate(pageSize, nowPage);
        for (OrderDetail orderDetail : list) {
			System.out.println(orderDetail);
		}
        
	}
   public static void  testsave(){
		OrderDetailDAO dao = new OrderDetailDAOimpl();
		OrderDetail orderDetail = new OrderDetail("5",4,22);
		 System.out.println(dao.save(orderDetail));
		
	}
	public static void testmodify(){
		OrderDetailDAO dao = new OrderDetailDAOimpl();
		OrderDetail orderDetail = new OrderDetail(1, "2", 2, 10);
		 System.out.println(dao.modify(orderDetail));
		
		
	}
	public static void testdelete(){
		int detailId = 3;
		OrderDetailDAO dao = new OrderDetailDAOimpl();
		 System.out.println(dao.delete(detailId));
		
	}
	public static void testfindAll(){
		OrderDetailDAO dao = new OrderDetailDAOimpl();
		List<OrderDetail> list = dao.findAll();
		for (OrderDetail orderDetail : list) {
			System.out.println(orderDetail);	
		}
		 
	}
	public static void testfindById(){
		int detailId = 6;
		OrderDetailDAO dao = new OrderDetailDAOimpl();
		OrderDetail  orderDetail = dao.findByDetailId(detailId);
		 System.out.println(orderDetail);
		 
	}
}
