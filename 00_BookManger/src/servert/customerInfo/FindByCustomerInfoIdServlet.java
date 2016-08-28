package servert.customerInfo;

import impl.CustomerInfoimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerInfoDAO;
import enetiy.CustomerInfo;

public class FindByCustomerInfoIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id")); 
		CustomerInfoDAO dao = new CustomerInfoimpl();
		CustomerInfo customerInfo = dao.findById(id);
		request.setAttribute("customerInfo", customerInfo);
		RequestDispatcher rd = request.getRequestDispatcher("background/updatecustomerInfo.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
