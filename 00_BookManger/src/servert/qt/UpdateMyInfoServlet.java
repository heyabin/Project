package servert.qt;

import impl.CustomerDetailInfoDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDetailInfoDAO;
import enetiy.CustomerDetailInfo;

public class UpdateMyInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	int custId = Integer.parseInt(request.getParameter("custId"));
	String custName = request.getParameter("custName");
	int sex = Integer.parseInt(request.getParameter("sex"));
	int age = Integer.parseInt(request.getParameter("age"));
	String address = request.getParameter("address");
	String email = request.getParameter("email");
	String tel = request.getParameter("tel");
	int qq = Integer.parseInt(request.getParameter("qq"));
	int countMoney = 1;
	CustomerDetailInfo book = new CustomerDetailInfo(custId, tel, address, sex, age, countMoney, qq);
	CustomerDetailInfoDAO dao = new CustomerDetailInfoDAOimpl();
	System.out.println(book+"===================");
	String msg = "修改客户详细信息失败!";
	String returnPath = "/FindByCustomerDetailInfoIdServlet?id=" + custId;
	if (dao.modify(book)) {
		msg = "修改客户详细信息成功!";
		returnPath ="/myshop.jsp";
	} 
	request.setAttribute("msg", msg);
	request.setAttribute("returnPath", returnPath);		
	request.getRequestDispatcher("background/msg.jsp").forward(request, response);
	}

}
