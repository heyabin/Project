package servert.qt;

import impl.CustomerDetailInfoDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDetailInfoDAO;

import enetiy.CustomerDetailInfo;
import enetiy.CustomerInfo;

public class AddCustomerDetailInfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		HttpSession session = request.getSession();
		int custId = Integer.parseInt(request.getParameter("custId"));
		String tel = request.getParameter("tel"); 
		String address = request.getParameter("address");
		int sex = Integer.parseInt(request.getParameter("sex"));
		int age = Integer.parseInt(request.getParameter("age"));
		int countMoney = Integer.parseInt(request.getParameter("countMoney"));
		int qq = Integer.parseInt(request.getParameter("qq"));
		
		CustomerDetailInfo customerDetailInfo = new CustomerDetailInfo(custId, tel, address, sex, age, countMoney, qq);
		CustomerDetailInfoDAO dao = new CustomerDetailInfoDAOimpl();
		if(customerDetailInfo  != null) {
			 session.setAttribute("customerDetailInfo", customerDetailInfo);
		}
		 String msg = "新增客户详细失败!";
	     String returnPath ="background/savecustomerDetailInfo.jsp";
		    if (dao.save(customerDetailInfo)) {
		    	msg = "新增客户详细信息成功！";
		    	returnPath = "/InitSevert";
			}
		    request.setAttribute("msg", msg);
		    request.setAttribute("returnPath", returnPath);
			RequestDispatcher rd = request.getRequestDispatcher("msg.jsp");
			rd.forward(request, response);
		
	}

}
