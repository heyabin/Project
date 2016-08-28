package servert.gwc;

import impl.BookInfoDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.IBookInforDAO;
import enetiy.BookInfo;

public class AddGwcItemServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
	    IBookInforDAO dao = new BookInfoDAOimpl();
	    BookInfo bookInfo = dao.findById(bookId);
	    GwcItem gwcItem = new GwcItem(bookId,bookInfo.getBookName(),bookInfo.getSmallImg(), bookInfo.getPrice(), bookInfo.getHyprice(), 1);
	    
	    Gwc gwc = null;
	    //session 相当于书包，判断session中是否存在购物车
	    HttpSession session = request.getSession();
	    if (session.getAttribute("gwc")== null) {
			gwc = new Gwc();
		}else {
			gwc =(Gwc)session.getAttribute("gwc");
		}
	    gwc.add(gwcItem);
    	   session.setAttribute("gwc", gwc);
    	   response.sendRedirect("gwc.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
