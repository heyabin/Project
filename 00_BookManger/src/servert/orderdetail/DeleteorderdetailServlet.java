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

public class DeleteorderdetailServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		  OrderDetailDAO dao = new OrderDetailDAOimpl();
		  String msg = "É¾³ý¶©µ¥ÏêÏ¸ÐÅÏ¢Ê§°Ü!";
		     String returnPath ="/FindAllorderdetailServlet?nowPage=1";
			    if (dao.delete(id)) {
			    	msg = "É¾³ý¶©µ¥ÏêÏ¸ÐÅÏ¢³É¹¦£¡";
			    	returnPath ="/FindAllorderdetailServlet?nowPage=1";
				}
			    request.setAttribute("msg", msg);
			    request.setAttribute("returnPath", returnPath);
				RequestDispatcher rd = request.getRequestDispatcher("background/msg.jsp");
				rd.forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}

}
