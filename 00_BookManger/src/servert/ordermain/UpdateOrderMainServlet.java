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

public class UpdateOrderMainServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�Ȼ���޸Ĳ���
		request.setCharacterEncoding("gbk");
		String orderNum  = request.getParameter("orderNum");
		int customerId  = Integer.parseInt(request.getParameter("orderNum"));
		String customerName  = request.getParameter("customerName");
		String tel = request.getParameter("tel");
		String address	 = request.getParameter("address");
		String status	 = request.getParameter("status");
		int adminId	 = Integer.parseInt(request.getParameter("adminId"));
		String context = request.getParameter("context");
		double sumprice = Double.valueOf(request.getParameter("sumprice"));
		OrderMain orderMain = new OrderMain(orderNum, customerId, customerName, tel, address, status, adminId, context, sumprice);
		OrderMainDAO dao = new OrderMainDAOimpl();
		String msg = "�޸Ķ�����Ϣʧ��";
		String returnPath = "/FindByOrderMainIdServlet?id="+orderNum;
		if (dao.modify(orderMain)) {
			msg = "�޸Ķ�����Ϣ�ɹ�!";
			returnPath ="/FindAllOrderMainServlet?nowPage=1";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);		
		request.getRequestDispatcher("background/msg.jsp").forward(request, response);
		
	}

}
