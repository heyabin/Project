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
		//�����������ַ���
		String orderNum  = request.getParameter("orderNum");
		int customerId  = Integer.parseInt(request.getParameter("customerId"));
		String customerName  = request.getParameter("customerName");
		String tel = request.getParameter("tel");
		String address	 = request.getParameter("address");
		String context = request.getParameter("context");
		double sumprice = Double.valueOf(request.getParameter("sumprice"));
		//����Щ���ݷŵ�ʵ����---ʵ����
		OrderMain orderMain = new OrderMain(orderNum, customerId, customerName, tel, address, "0", 0, context, sumprice);
		//���ݱ����String�ַ���---String sql�ַ���
		//����dao�����ֱ����---String sql�ַ���
		//����update�����ְ��ַ����������ݿ�---String sql�ַ���
		OrderMainDAO dao = new OrderMainDAOimpl();
		String msg = "����������Ϣʧ��";
		String returnPath = "/FindAllOrderMainServlet?nowPage=1";
		if (dao.save(orderMain)) {
			msg = "����������Ϣ�ɹ�!";
			returnPath ="/FindAllOrderMainServlet?nowPage=1";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);		
		request.getRequestDispatcher("background/msg.jsp").forward(request, response);
	}
	}
