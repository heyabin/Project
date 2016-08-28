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
import enetiy.News;

public class FindByNewsIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		NewDAO dao = new NewDAOimpl();
		News  news = dao.find(id);
		
		 request.setAttribute("news", news);
		  RequestDispatcher rd = request.getRequestDispatcher("background/updateNewsr.jsp");
		  rd.forward(request, response);
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  this.doGet(request, response);
	}

}
