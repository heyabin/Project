package servert.ordermain;

import impl.OrderMainDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderMainDAO;

import enetiy.OrderMain;

public class FindByOrderMainIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		OrderMainDAO dao = new OrderMainDAOimpl();
		 OrderMain orderMain =  dao.findById(id);
		request.setAttribute("id", id);
		request.setAttribute("orderMain", orderMain);
		RequestDispatcher rd = request.getRequestDispatcher("background/updateOrderMain.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
