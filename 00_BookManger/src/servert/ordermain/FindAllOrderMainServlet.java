package servert.ordermain;

import impl.OrderMainDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderMainDAO;

import enetiy.OrderMain;

import tool.Config;

public class FindAllOrderMainServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int nowPage =Integer.parseInt(request.getParameter("nowPage"));
		int pageSize = Config.page_size;
		int pageCount = 0;
		List<OrderMain> list = null;
		
		OrderMainDAO dao = new OrderMainDAOimpl();
		    list =  dao.getnowPageData(pageSize, nowPage);
		    pageCount = dao.getpageCount(pageSize);
		    request.setAttribute("list", list );
		    request.setAttribute("pageCount", pageCount);
		    request.setAttribute("nowPage", nowPage);
		    RequestDispatcher rd= request.getRequestDispatcher("background/OrderMainList.jsp");
		    rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		     this.doGet(request, response);
	}

}
