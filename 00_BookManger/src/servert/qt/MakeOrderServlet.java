package servert.qt;

import impl.OrderDetailDAOimpl;
import impl.OrderMainDAOimpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.OrderDetailDAO;
import dao.OrderMainDAO;
import dbutil.DButil;

import servert.gwc.Gwc;
import servert.gwc.GwcItem;
import tool.DateConvernt;

import enetiy.CustomerInfo;
import enetiy.OrderDetail;
import enetiy.OrderMain;

public class MakeOrderServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		// �����������һ������
		HttpSession session = request.getSession();
		CustomerInfo customerInfo = (CustomerInfo) session.getAttribute("customerInfo");
		Gwc gwc = (Gwc) session.getAttribute("gwc");
		// �������
		String orderNum = DateConvernt.getNowDateStr("yyyyMMddHHmmssSSS");
		// �ͻ����
		int customerId = customerInfo.getCustId();
		// �ջ�������
		String customerName = request.getParameter("customerName");
		// �ջ��˵绰
		String tel = request.getParameter("tel");
		// �ջ���ַ
		String address = request.getParameter("address");
		// ��ע
		String context = request.getParameter("context");
		// δ����
		String status = "0";
		// �ܼ�
		float sumprice = gwc.getOldHyPrices();
		// ������ϸ������������
		OrderMain orderMain = new OrderMain(orderNum, customerId, customerName,
				tel, address, status, context, sumprice);
			
		List<OrderDetail> details = new ArrayList<OrderDetail>();
		Collection<GwcItem> items = gwc.getItemNum();
		for (GwcItem gwcItem : items) {
			OrderDetail detail = new OrderDetail(orderNum, gwcItem.getBookId(),
					gwcItem.getNum());
			details.add(detail);
		}
		OrderMainDAO mainDAO = new OrderMainDAOimpl();
		OrderDetailDAO detailDAO = new OrderDetailDAOimpl();
		Connection con = null;
		try {
			DButil butil = new DButil();
		    con = butil.getCon();
			con.setAutoCommit(false);
	        mainDAO.save(con, orderMain);
			detailDAO.save(con, details);
			con.commit();
			//���»�һ���¶����ɹ�ҳ��
			request.setAttribute("orderNum", orderNum);
			gwc.clear();
			RequestDispatcher rd = request.getRequestDispatcher("makeorderOK.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("makeorderError.jsp");
			rd.forward(request, response);
		}finally {
			try {
				if (con != null) {
					con.close();
					con = null;
				}	
			} catch (SQLException e) {
				// TODO: handle exception
			}
			
		}
	
		// ���ѽ��customerdetailinfo
	}

}
