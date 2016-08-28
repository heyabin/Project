package servert.customerInfo;

import impl.CustomerInfoimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerInfoDAO;

public class DeleteCustomerInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id  =Integer.parseInt(request.getParameter("id"));
		CustomerInfoDAO dao = new CustomerInfoimpl();
		String msg = "删除用户信息";
		String   returnPath  = "/FindAllCustomerInfoServlet?nowPage = 1";
		if (dao.delete(id)) {
			msg = "删除用户信息成功!";
			returnPath ="/FindAllCustomerInfoServlet?nowPage=1";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);		
		request.getRequestDispatcher("background/msg.jsp").forward(request, response);
		 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
