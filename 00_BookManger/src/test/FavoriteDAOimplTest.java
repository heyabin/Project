package test;

import impl.CustomerInfoimpl;
import impl.FavoriteDAOimpl;

import java.util.Date;
import java.util.List;

import tool.DateConvernt;

import dao.CustomerInfoDAO;
import dao.FavoriteDAO;
import enetiy.CustomerInfo;
import enetiy.Favorite;

public class FavoriteDAOimplTest {
	public static void main(String[] args) {
		//testdelete();
		//testfiandAll();
		//testfiandById();
		testsave();
		//testmodify();
		//testde();
		//testd();
	}
	
	public static void testd(){
		int  pageSize = 4;
		int nowPage = 2;
		
		FavoriteDAO dao = new FavoriteDAOimpl();
       	List<Favorite> list = dao.getnowPageDate(pageSize, nowPage);
       	for (Favorite favorite : list) {
			System.out.println(favorite);
		}
       	
       	
	}
	public static void testde(){
		int  pageSize = 1;
		FavoriteDAO dao = new FavoriteDAOimpl();
		System.out.println(dao.getnowPage(pageSize));
	
	}
	public static void testdelete(){
		int  favoriteId = 1;
		FavoriteDAO dao = new FavoriteDAOimpl();
		 System.out.println(dao.delete(favoriteId));
	}
	public static void testfiandAll(){
		FavoriteDAO dao = new FavoriteDAOimpl();
		List<Favorite> list  = dao.findAll();
		 for (Favorite favorite : list) {
			System.out.println(favorite);
		}
			
    }
	public static void testfiandById(){
		int favoriteId = 3;
		FavoriteDAO dao = new FavoriteDAOimpl();
		Favorite favorite = dao.findById(favoriteId);
		System.out.println(favorite);
		
	}
	 public static void testmodify(){
		 FavoriteDAO dao = new FavoriteDAOimpl();
		 String btd = "2015-3-11";
		 Date date =  DateConvernt.ConvertToDate(btd);
		 Favorite favorite = new Favorite(3, 3, 2, date, "ssss");
		 System.out.println(dao.modify(favorite)); 
	 
	 }
	 public static void testsave(){
		 FavoriteDAO dao = new FavoriteDAOimpl();
		 String btd = "2014-1-2";
		  Date date =  DateConvernt.ConvertToDate(btd);
		 Favorite favorite = new Favorite(3, 2, date, "ddd");
		 System.out.println(dao.save(favorite)); 
	     }
	
}

