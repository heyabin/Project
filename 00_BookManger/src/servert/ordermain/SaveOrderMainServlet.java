package servert.ordermain;

import impl.OrderMainDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderMainDAO;
import enetiy.OrderMain;

public class SaveOrderMainServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//从浏览器获得字符串
		String orderNum  = request.getParameter("orderNum");
		int customerId  = Integer.parseInt(request.getParameter("customerId"));
		String customerName  = request.getParameter("customerName");
		String tel = request.getParameter("tel");
		String address	 = request.getParameter("address");
		String context = request.getParameter("context");
		double sumprice = Double.valueOf(request.getParameter("sumprice"));
		//将这些数据放到实体类---实体类
		OrderMain orderMain = new OrderMain(orderNum, customerId, customerName, tel, address, "0", 0, context, sumprice);
		//数据变成了String字符串---String sql字符串
		//调用dao数据又变成了---String sql字符串
		//调用update方法又把字符串塞到数据库---String sql字符串
		OrderMainDAO dao = new OrderMainDAOimpl();
		String msg = "新增订单信息失败";
		String returnPath = "/FindAllOrderMainServlet?nowPage=1";
		if (dao.save(orderMain)) {
			msg = "新增订单信息成功!";
			returnPath ="/FindAllOrderMainServlet?nowPage=1";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);		
		request.getRequestDispatcher("background/msg.jsp").forward(request, response);
	}
	}
