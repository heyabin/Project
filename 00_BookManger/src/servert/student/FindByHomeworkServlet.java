package servert.student;

import impl.HomeworkDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HomeworkDAO;
import enetiy.Homework;
import enetiy.Teacher;

public class FindByHomeworkServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String homeName = request.getParameter("homeName");
		HomeworkDAO dao = new HomeworkDAOimpl();
		List<Homework> homeworks = null;
		 homeworks =  dao.find(homeName);
		 request.setAttribute("homeworks", homeworks);
		  RequestDispatcher rd = request.getRequestDispatcher("background/updateHomework.jsp");
		  rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
