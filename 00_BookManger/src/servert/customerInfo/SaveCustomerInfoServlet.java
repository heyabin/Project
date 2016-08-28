package servert.customerInfo;

import impl.CustomerInfoimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerInfoDAO;
import enetiy.CustomerInfo;

public class SaveCustomerInfoServlet extends HttpServlet {

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
	String msg = "�����û���Ϣʧ��!";
	String returnPath = "/background/savecustomerInfo.jsp";
	if (dao.save(customerInfo)) {
		msg = "�����û���Ϣ�ɹ�!";
		returnPath ="/FindAllCustomerInfoServlet?nowPage=1";
	} 
	request.setAttribute("msg", msg);
	request.setAttribute("returnPath", returnPath);		
	request.getRequestDispatcher("background/msg.jsp").forward(request, response);
	}

}
