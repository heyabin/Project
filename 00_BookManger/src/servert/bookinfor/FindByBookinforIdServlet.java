package servert.bookinfor;

import impl.BookInfoDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IBookInforDAO;
import enetiy.BookInfo;

public class FindByBookinforIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		IBookInforDAO dao = new BookInfoDAOimpl();
		BookInfo info =	 dao.findById(id);
		request.setAttribute("info", info);
		System.out.println(info);
		  RequestDispatcher rd = request.getRequestDispatcher("background/updateBookinfor.jsp");
		  rd.forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
