package servert.gwc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateGwcItemNumServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id  = Integer.parseInt(request.getParameter("id"));
		int num  = Integer.parseInt(request.getParameter("num"));
		HttpSession session  = request.getSession();
		 Gwc gwc= (Gwc)session.getAttribute("gwc");
		 gwc.updataItemNum(id, num);
		response.sendRedirect("gwc.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
