package servert.student;

import impl.StudentDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.rmi.server.Dispatcher;

import dao.IStudentDAO;
import enetiy.Student;

public class FindByStudentIdServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//.jsp传递的是name属性的值
		int id =Integer.parseInt(request.getParameter("id"));  
		IStudentDAO dao = new StudentDAOimpl();
		  Student  stu = dao.findById(id);
		  request.setAttribute("stu", stu);
		  RequestDispatcher rd = request.getRequestDispatcher("background/updateStudent.jsp");
		  rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
