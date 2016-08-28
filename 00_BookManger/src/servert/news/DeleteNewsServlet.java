package servert.news;

import impl.NewDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewDAO;

public class DeleteNewsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		 NewDAO dao = new NewDAOimpl();
		 String msg = "删除新闻信息失败!";
	     String returnPath ="/FindAllNewsServlet?nowPage=1";
		    if (dao.delete(id)) {
		    	msg = "删除新闻信息成功！";
		    	returnPath ="/FindAllNewsServlet?nowPage=1";
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
