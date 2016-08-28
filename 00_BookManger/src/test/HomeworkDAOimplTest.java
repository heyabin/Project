package test;

import impl.HomeworkDAOimpl;
import impl.StudentDAOimpl;
import impl.TeacherDAOimpl;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import tool.DateConvernt;
import dao.HomeworkDAO;
import dao.IStudentDAO;
import dao.TeacherDAO;
import enetiy.Homework;
import enetiy.Teacher;

public class HomeworkDAOimplTest {
	public static void main(String[] args) {
		//testsave();
		testdelete();
		//testmodefy();
		//testfindById();
		//testfiandAll();
	}
	public static void testsave(){
		String homesumbmit = "1995-2-12";
		Date btd = DateConvernt.ConvertToDate(homesumbmit);
		Homework homework = new Homework("ddd", "wwww", btd, 44, "ddd");
		 HomeworkDAO dao = new HomeworkDAOimpl();
		System.out.println(dao.save(homework)); 
	}
	public static void testdelete(){
		int homeId =10;
		 HomeworkDAO dao = new HomeworkDAOimpl();
		System.out.println(dao.delete(homeId)); 
    }
	public static void testmodefy(){
		String homesumbmit = "4/4/1994";
		Date btd = DateConvernt.ConvertToDate(homesumbmit, "MM/dd/yyyy");
		Homework homework = new Homework("ttt", "rrr", btd, 22, "ddd");
		homework.setHomeId(10);
		 HomeworkDAO dao = new HomeworkDAOimpl();
			System.out.println(dao.update(homework)); 
	}

	public static void testfindById(){
		String  homeName = "Êý×ÖÍ¼Ïñ";
        HomeworkDAO dao = new HomeworkDAOimpl();
		List<Homework> homework = dao.find(homeName);
		for (Homework homework2 : homework) {
			System.out.println(homework2);
		}

	}
	public static void testfiandAll(){
		HomeworkDAO dao = new HomeworkDAOimpl();
		List<Homework> list  = dao.findAll();
		 for (Homework homework : list) {
			 System.out.println(homework);
		}
	}
}