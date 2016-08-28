package servert.student;

import impl.StudentDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IStudentDAO;


import enetiy.Student;


import tool.DateConvernt;

public class SaveStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stuName = request.getParameter("stuName");
		int stuAge = Integer.parseInt(request.getParameter("stuAge"));
		String btdStr = request.getParameter("stuBtd"); 
		Date stuBtd = DateConvernt.ConvertToDate(btdStr);
		int sex = Integer.parseInt(request.getParameter("stuSex"));
		boolean stuSex = (sex == 1);
		String stuTel = request.getParameter("stuTel");
		
		Student stu = new Student(stuName, stuAge, stuBtd, stuSex, stuTel);
		IStudentDAO dao = new StudentDAOimpl();
		 String msg = "新增学生信息失败!";
	     String returnPath ="background/saveStudent.jsp";
		    if (dao.save(stu)) {
		    	msg = "新增学生信息成功！";
		    	returnPath = "/FindAllStudentServlet?nowPage=1";
			}
		    request.setAttribute("msg", msg);
		    request.setAttribute("returnPath", returnPath);
			RequestDispatcher rd = request.getRequestDispatcher("background/msg.jsp");
			rd.forward(request, response);

	}

}
