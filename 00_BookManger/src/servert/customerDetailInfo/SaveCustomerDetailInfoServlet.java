package servert.customerDetailInfo;

import impl.BookTypeDAOimpl;
import impl.CustomerDetailInfoDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDetailInfoDAO;
import dao.IBookTypeDAO;
import enetiy.BookType;
import enetiy.CustomerDetailInfo;

public class SaveCustomerDetailInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int custId = Integer.parseInt(request.getParameter("custId"));
		String tel = request.getParameter("tel"); 
		String address = request.getParameter("address");
		int sex = Integer.parseInt(request.getParameter("sex"));
		int age = Integer.parseInt(request.getParameter("age"));
		int countMoney = Integer.parseInt(request.getParameter("countMoney"));
		int qq = Integer.parseInt(request.getParameter("qq"));
		
		CustomerDetailInfo stu = new CustomerDetailInfo(custId, tel, address, sex, age, countMoney, qq);
		CustomerDetailInfoDAO dao = new CustomerDetailInfoDAOimpl();
		 String msg = "新增图书类别失败!";
	     String returnPath ="background/savecustomerDetailInfo.jsp";
		    if (dao.save(stu)) {
		    	msg = "新增学生信息成功！";
		    	returnPath = "/FindAllCustomerDetailInfoServlet?nowPage=1";
			}
		    request.setAttribute("msg", msg);
		    request.setAttribute("returnPath", returnPath);
			RequestDispatcher rd = request.getRequestDispatcher("background/msg.jsp");
			rd.forward(request, response);
	}

}
