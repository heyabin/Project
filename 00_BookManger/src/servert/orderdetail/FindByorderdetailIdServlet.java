package servert.orderdetail;

import impl.OrderDetailDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDetailDAO;
import enetiy.OrderDetail;

public class FindByorderdetailIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		 OrderDetailDAO dao = new OrderDetailDAOimpl();
		  OrderDetail orderDetail =  dao.findByDetailId(id);
		  request.setAttribute("orderDetail", orderDetail);
		  System.out.println("--------------------");
		  System.out.println(orderDetail);
		  RequestDispatcher rd = request.getRequestDispatcher("background/updateOrderdetail.jsp");
		  rd.forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
