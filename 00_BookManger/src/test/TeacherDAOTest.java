package test;



import impl.StudentDAOimpl;
import impl.TeacherDAOimpl;

import java.util.Date;
import java.util.List;

import tool.DateConvernt;

import dao.IStudentDAO;
import dao.TeacherDAO;

import enetiy.Student;
import enetiy.Teacher;

public class TeacherDAOTest {
	public static void main(String[] args) {
		testsave();
		//testdelete();
		//testmodefy();
		//testfindById();
		//testfiandAll();
	}
	public static void testsave(){
		String btdstr = "1995-2-12";
		boolean teaSex = false;
		Date btd = DateConvernt.ConvertToDate(btdstr);
		Teacher teacher = new Teacher("kss", 21,btd, false, "22222222","ÑÓ°²");
		TeacherDAO dao = new TeacherDAOimpl();
		System.out.println(dao.save(teacher)); 
		
	}
	public static void testdelete(){
		int stuId = 16;
		IStudentDAO dao = new StudentDAOimpl();
		System.out.println(dao.delete(stuId)); 
    }
	public static void testmodefy(){
		String dateStr = "4/4/1994";
		Date btd = DateConvernt.ConvertToDate(dateStr, "MM/dd/yyyy");
		Teacher teacher = new Teacher("hhhh", 21, btd, false, "888888888","fff");
		teacher.setTeaId(9);
		TeacherDAO dao = new TeacherDAOimpl();
		System.out.println(dao.modefy(teacher)); 
	}

	public static void testfindById(){
		int teaId = 3;
		TeacherDAO dao = new TeacherDAOimpl();
	   Teacher teacher = dao.findById(teaId);
	  System.out.println(teacher);
	}
	public static void testfiandAll(){
		TeacherDAO dao = new TeacherDAOimpl();
		  List<Teacher> list  = dao.findAll();
		 for (Teacher teacher : list) {
			System.out.println(teacher);
		}
	}

}
