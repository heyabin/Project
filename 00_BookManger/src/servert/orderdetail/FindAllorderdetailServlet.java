package servert.orderdetail;

import impl.OrderDetailDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDetailDAO;

import enetiy.OrderDetail;

import tool.Config;

public class FindAllorderdetailServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    int nowPage = Integer.parseInt(request.getParameter("nowPage"));
    int pageSize = Config.page_size;
    int pageCount = 0;
    List<OrderDetail> list = null;
         OrderDetailDAO dao = new OrderDetailDAOimpl();
         list = dao.getnowPageDate(pageSize, nowPage);
         pageCount = dao.getpageCount(pageSize);
         request.setAttribute("nowPage", nowPage);
   	  request.setAttribute("pageCount",pageCount );
   	  request.setAttribute("list",list);
   	  RequestDispatcher rd = request.getRequestDispatcher("background/OrderdetailList.jsp");
   	  rd.forward(request, response);
         
	}
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}

}
