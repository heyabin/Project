package servert.ordermain;

import impl.OrderMainDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderMainDAO;

public class DeleteOrdermainServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String  id = request.getParameter("id");
		OrderMainDAO dao = new  OrderMainDAOimpl();
		String msg = "删除订单信息";
		String returnPath = "background/FindAllOrderMainServlet?nowPage = 1";
		if (dao.delete(id)) {
			msg = "删除订单信息成功!";
			returnPath ="/FindAllOrderMainServlet?nowPage=1";
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
