package test;

import impl.NewDAOimpl;
import impl.StudentDAOimpl;

import java.util.Date;
import java.util.List;

import tool.DateConvernt;
import dao.IStudentDAO;
import dao.NewDAO;
import enetiy.News;
import enetiy.Student;

public class NewDAOimplTest {
    public static void main(String[] args) {
		//testsave();
    	//testdelete();
    	testupdate();
    	//testfindById();
    	//testfiandAll();
    	//tests();
    	//test();
	}
    public static void test(){
		 int pageSize = 1;
		NewDAO dao = new NewDAOimpl();
     System.out.println(dao.getpageCount(pageSize));
	}
    public static void tests(){
		int nowPage = 3;
		 int pageSize = 3;
		NewDAO dao = new NewDAOimpl();
		List<News> list = dao.getnowPageData(nowPage, pageSize);
		for (News news : list) {
			System.out.println(news);	
		}
	}
    public static void testsave(){
		boolean isDelete = false;
		String str = "1995-2-12";
		Date btd = DateConvernt.ConvertToDate(str);
		News news = new News(2, "hh", "ss", btd);
		NewDAO dao = new NewDAOimpl();
		System.out.println(dao.save(news)); 
		
	}
    public static void testdelete(){
		int newsId = 13;
		NewDAO dao = new NewDAOimpl();
		System.out.println(dao.delete(newsId)); 
    }
    public static void testupdate(){
		String dateStr = "4/4/2015";
		Date btd = DateConvernt.ConvertToDate(dateStr, "MM/dd/yyyy");
        News stu = new News(2, "dd", "dd", btd);
		stu.setNewsId(6);
		NewDAO dao = new NewDAOimpl();
		System.out.println(dao.update(stu)); 
	}
    public static void testfindById(){
		int newsId =1;
		NewDAO dao = new NewDAOimpl();
		News news = dao.find(newsId);
	  System.out.println(news);
	}
    public static void testfiandAll(){
    	NewDAO dao = new NewDAOimpl();
		  List<News>list  = dao.findAll();
		  for (News news : list) {
			System.out.println(news);
		}
	}
}
