package servert.qt;

import impl.CustomerInfoimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerInfoDAO;

import enetiy.CustomerInfo;


public class UpdateMyPwdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		String pwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		CustomerInfo user = (CustomerInfo)session.getAttribute("customerInfo");
		CustomerInfo customerInfo = new CustomerInfo(user.getCustName(), pwd,user.getEmail() );
		CustomerInfoDAO dao = new CustomerInfoimpl();
		String path = "updatePwd.jsp";
		if(dao.modify(customerInfo)) {
			path = "qtindex.jsp";
			session.setAttribute("customerInfo", customerInfo);
		}
		response.sendRedirect(path);
	}

}
