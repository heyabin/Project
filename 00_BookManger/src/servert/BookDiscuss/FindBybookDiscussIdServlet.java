package servert.BookDiscuss;

import impl.BookDiscussDAOimpl;
import impl.BookInfoDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDiscussDAO;
import dao.IBookInforDAO;
import enetiy.BookDiscuss;
import enetiy.BookInfo;

public class FindBybookDiscussIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int  id  = Integer.parseInt(request.getParameter("id"));
		 BookDiscussDAO dao = new BookDiscussDAOimpl();
		     BookDiscuss bookDiscuss = dao.findById2(id); 
			request.setAttribute("bookDiscuss", bookDiscuss);
			  RequestDispatcher rd = request.getRequestDispatcher("background/updateBookdiscuss.jsp");
			  rd.forward(request, response);
		 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
