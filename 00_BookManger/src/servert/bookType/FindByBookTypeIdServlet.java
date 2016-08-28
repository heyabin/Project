package servert.bookType;

import impl.BookTypeDAOimpl;
import impl.StudentDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IBookTypeDAO;
import dao.IStudentDAO;
import enetiy.BookType;
import enetiy.Student;

public class FindByBookTypeIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));  
		IBookTypeDAO dao = new BookTypeDAOimpl();
		BookType stu = dao.findById(id);
		 System.out.println(stu);
		request.setAttribute("stu", stu);
		RequestDispatcher rd = request.getRequestDispatcher("background/updateBookType.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
