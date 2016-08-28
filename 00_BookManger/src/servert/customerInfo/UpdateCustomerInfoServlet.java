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

public class UpdateCustomerInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		int custId =Integer.parseInt(request.getParameter("custId"));
		String custName  = request.getParameter("custName");
		String  pwd = request.getParameter("pwd");
		String email =request.getParameter("email");
		CustomerInfo customerInfo = new CustomerInfo(custId, custName, pwd, email);
		CustomerInfoDAO dao = new CustomerInfoimpl();
	String msg = "修改用户信息失败!";
	String returnPath = "/FindByCustomerInfoIdServlet?id=" +custId;
	if (dao.modify(customerInfo)) {
		msg = "修改用户信息成功!";
		returnPath ="/FindAllCustomerInfoServlet?nowPage=1";
	} 
	request.setAttribute("msg", msg);
	request.setAttribute("returnPath", returnPath);		
	request.getRequestDispatcher("background/msg.jsp").forward(request, response);
}

}
