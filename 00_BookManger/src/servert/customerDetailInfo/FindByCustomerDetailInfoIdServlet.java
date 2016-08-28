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

public class FindByCustomerDetailInfoIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));  
		CustomerDetailInfoDAO dao = new CustomerDetailInfoDAOimpl();
		CustomerDetailInfo stu = dao.findById(id);
		request.setAttribute("stu", stu);
		RequestDispatcher rd = request.getRequestDispatcher("background/updateCustomerDetailInfo.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
