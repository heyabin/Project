package servert.qt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyKJ extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	      HttpSession session = request.getSession(true);
        //û�е�¼
        if (session.getAttribute("customerInfo") == null) {
        	response.sendRedirect("qtlogin.jsp");
		//��¼��
		}else{
			response.sendRedirect("qtindex.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
