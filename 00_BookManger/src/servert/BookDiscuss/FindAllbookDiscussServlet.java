package servert.BookDiscuss;

import impl.BookDiscussDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDiscussDAO;

import enetiy.BookDiscuss;

import test.BookDiscussDAOimplTest;
import tool.Config;

public class FindAllbookDiscussServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int nowPage =Integer.parseInt(request.getParameter("nowPage"));
		int pageSize = Config.page_size;
		int pageCount = 0;
		List<BookDiscuss> bookDiscusses = null;
		BookDiscussDAO dao = new BookDiscussDAOimpl();
		bookDiscusses = dao.getnowPageDate(pageSize, nowPage);
		pageCount = dao.getPageCount(pageSize);
		
		request.setAttribute("bookDiscusses", bookDiscusses);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageCount", pageCount);
		RequestDispatcher rd = request.getRequestDispatcher("background/bookdiscussesList.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	
	}

}
