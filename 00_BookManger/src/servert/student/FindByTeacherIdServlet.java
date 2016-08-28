package servert.student;

import impl.TeacherDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeacherDAO;
import enetiy.Teacher;

public class FindByTeacherIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int teaId =Integer.parseInt(request.getParameter("teaId")); 
		TeacherDAO dao = new TeacherDAOimpl();
		Teacher teacher = new Teacher();
		   teacher =   dao.findById(teaId);
		 request.setAttribute("teacher", teacher);
		  RequestDispatcher rd = request.getRequestDispatcher("background/updateTeacher.jsp");
		  rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
