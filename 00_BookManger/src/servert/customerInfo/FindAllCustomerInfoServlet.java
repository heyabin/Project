package servert.customerInfo;

import impl.CustomerInfoimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.CustomerInfoDAOimplTest;
import tool.Config;

import dao.CustomerInfoDAO;
import enetiy.CustomerInfo;

public class FindAllCustomerInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	    int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		int pageCount  = 0;
		List<CustomerInfo> list = null;
		int pageSize = Config.page_size;
		//每页的大小
		CustomerInfoDAO dao = new CustomerInfoimpl();
		pageCount = dao.getpageCount(pageSize);
     	list = dao.getnowPageData(pageSize, nowPage);
     	
     	request.setAttribute("list",list );
     	request.setAttribute("pageCount", pageCount);
	    request.setAttribute("nowPage",nowPage );
	    
	  RequestDispatcher rd = request.getRequestDispatcher("background/customerInfoList.jsp");
	  rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
