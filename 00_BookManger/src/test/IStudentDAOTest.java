package test;



import impl.StudentDAOimpl;

import java.util.Date;
import java.util.List;

import tool.DateConvernt;

import dao.IStudentDAO;

import enetiy.Student;

public class IStudentDAOTest {
	public static void main(String[] args) {
		//testsave();
		//testdelete();
		testmodefy();
		//testfindById();
		//testfiandAll();
	}
	public static void testsave(){
		String btdstr = "1995-2-12";
		boolean stuSex = false;
		Date btd = DateConvernt.ConvertToDate(btdstr);
		Student stu = new Student("kss", 21,btd, false, "22222222");
		IStudentDAO dao = new StudentDAOimpl();
		System.out.println(dao.save(stu)); 
		
	}
	public static void testdelete(){
		int stuId = 16;
		IStudentDAO dao = new StudentDAOimpl();
		System.out.println(dao.delete(stuId)); 
    }
	public static void testmodefy(){
		String dateStr = "4/4/1994";
		Date btd = DateConvernt.ConvertToDate(dateStr, "MM/dd/yyyy");
		Student stu = new Student("hhhh", 21, btd, false, "888888888");
		stu.setStuId(25);
		IStudentDAO studentDAO = new StudentDAOimpl();
		System.out.println(studentDAO.modefy(stu));
	}

	public static void testfindById(){
		int stuId = 13;
	  IStudentDAO dao = new StudentDAOimpl();
	   Student  stu = dao.findById(stuId);
	  System.out.println(stu);
	}
	public static void testfiandAll(){
		IStudentDAO dao = new StudentDAOimpl();
		  List<Student> list  = dao.findAll();
		  for (Student student : list) {
				System.out.println(student);
			}
	}

}
