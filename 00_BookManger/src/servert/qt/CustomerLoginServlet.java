package servert.qt;

import impl.CustomerDetailInfoDAOimpl;
import impl.CustomerInfoimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDetailInfoDAO;
import dao.CustomerInfoDAO;
import enetiy.CustomerDetailInfo;
import enetiy.CustomerInfo;

public class CustomerLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		CustomerInfoDAO customerInfoDAO = new CustomerInfoimpl();
		CustomerInfo customerInfo = customerInfoDAO.findNameAndPassword(username, password);
		String path = "qtlogin.jsp";
		if (customerInfo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("customerInfo", customerInfo);
			CustomerDetailInfoDAO customerDetailInfoDAO = new CustomerDetailInfoDAOimpl();
			CustomerDetailInfo customerDetailInfo = customerDetailInfoDAO.findById(customerInfo.getCustId());
			if (customerDetailInfo != null) {
				session.setAttribute("customerDetailInfo", customerDetailInfo);	
			}
			path = "InitSevert";
		}
		response.sendRedirect(path);
		

	}

}
