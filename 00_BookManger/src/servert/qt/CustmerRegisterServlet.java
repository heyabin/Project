package servert.qt;

import impl.CustomerInfoimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerInfoDAO;
import enetiy.CustomerInfo;

public class CustmerRegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		String custName  = request.getParameter("custName");
		String  pwd = request.getParameter("pwd");
		String email =request.getParameter("email");
		CustomerInfo customerInfo = new CustomerInfo( custName, pwd, email);
		CustomerInfoDAO dao = new CustomerInfoimpl();
	String msg = "新增用户信息失败!";
	String returnPath = "Register.jsp";
	if (dao.save(customerInfo)) {
		msg = "新增用户信息成功!";
		returnPath ="/InitSevert";
	} 
	request.setAttribute("msg", msg);
	request.setAttribute("returnPath", returnPath);		
	request.getRequestDispatcher("background/msg.jsp").forward(request, response);
	}
}