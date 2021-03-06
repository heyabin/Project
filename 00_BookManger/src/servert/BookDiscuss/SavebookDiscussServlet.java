package servert.BookDiscuss;

import impl.BookDiscussDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDiscussDAO;
import enetiy.BookDiscuss;

public class SavebookDiscussServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		int  bookId =Integer.parseInt(request.getParameter("bookId"));
		int  custId  = Integer.parseInt(request.getParameter("custId"));
		String  context = request.getParameter("context");
		String  states = request.getParameter("states");
		
		BookDiscuss bookDiscuss = new BookDiscuss(bookId, custId, context, states);
		BookDiscussDAO dao = new BookDiscussDAOimpl();
		String msg = "新增书评信息失败!";
	     String returnPath ="background/saveBookdiscuss.jsp" ;
		    if (dao.save(bookDiscuss)) {
		    	msg = "新增书评信息成功！";
		    	returnPath = "/FindAllbookDiscussServlet?nowPage=1";
			}
		    request.setAttribute("msg", msg);
		    request.setAttribute("returnPath", returnPath);
			RequestDispatcher rd = request.getRequestDispatcher("background/msg.jsp");
			rd.forward(request, response);
	}
		
	}


