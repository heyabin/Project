package servert.orderdetail;

import impl.NewDAOimpl;
import impl.OrderDetailDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewDAO;
import dao.OrderDetailDAO;

import enetiy.OrderDetail;

public class SaveorderdetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("gbk");
		String orderNum = request.getParameter("orderNum");
		int bookId =Integer.parseInt(request.getParameter("bookId"));
		int num =Integer.parseInt(request.getParameter("num"));
		OrderDetail orderDetail = new OrderDetail(orderNum, bookId, num);
		OrderDetailDAO dao = new OrderDetailDAOimpl();
		String msg = "新增订单详细信息失败!";
	     String returnPath ="background/saveorderdetail.jsp";
		    if (dao.save(orderDetail)) {
		    	msg = "新增订单详细成功！";
		    	returnPath = "/FindAllorderdetailServlet?nowPage=1";
			}
		    request.setAttribute("msg", msg);
		    request.setAttribute("returnPath", returnPath);
			RequestDispatcher rd = request.getRequestDispatcher("background/msg.jsp");
			rd.forward(request, response);
		
		
	}

}
