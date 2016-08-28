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
		// 订单主表插入一条数据
		HttpSession session = request.getSession();
		CustomerInfo customerInfo = (CustomerInfo) session.getAttribute("customerInfo");
		Gwc gwc = (Gwc) session.getAttribute("gwc");
		// 订单编号
		String orderNum = DateConvernt.getNowDateStr("yyyyMMddHHmmssSSS");
		// 客户编号
		int customerId = customerInfo.getCustId();
		// 收货人姓名
		String customerName = request.getParameter("customerName");
		// 收货人电话
		String tel = request.getParameter("tel");
		// 收货地址
		String address = request.getParameter("address");
		// 备注
		String context = request.getParameter("context");
		// 未处理
		String status = "0";
		// 总价
		float sumprice = gwc.getOldHyPrices();
		// 订单明细表插入多条数据
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
			//重新画一个下订单成功页面
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
	
		// 消费金额customerdetailinfo
	}

}
