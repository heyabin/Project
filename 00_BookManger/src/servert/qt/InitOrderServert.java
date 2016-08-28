package servert.qt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enetiy.CustomerDetailInfo;
import enetiy.CustomerInfo;

public class InitOrderServert extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String path = "makeOrder.jsp";
		//Ã»ÓÐµÇÂ¼
		if (session.getAttribute("customerInfo") == null) {
			path = "qtlogin.jsp";
		}
		response.sendRedirect(path);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
