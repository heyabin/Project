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

public class DeletebookDiscussServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
	 BookDiscussDAO dao = new BookDiscussDAOimpl();
	 String msg = "删除书评信息失败!";
     String returnPath ="background/bookdiscussesList.jsp" ;
	    if (dao.delete(id)) {
	    	msg = "删除书评信息成功！";
	    	returnPath = "/FindAllbookDiscussServlet?nowPage=1";
		}
	    request.setAttribute("msg", msg);
	    request.setAttribute("returnPath", returnPath);
		RequestDispatcher rd = request.getRequestDispatcher("background/msg.jsp");
		rd.forward(request, response);
	 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
