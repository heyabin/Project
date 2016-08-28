package servert.customerDetailInfo;

import impl.BookTypeDAOimpl;
import impl.CustomerDetailInfoDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Config;
import dao.CustomerDetailInfoDAO;
import dao.IBookTypeDAO;
import enetiy.BookType;
import enetiy.CustomerDetailInfo;

public class FindAllCustomerDetailInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		//当前页的具体数据
		List<CustomerDetailInfo> list = null;
		int pageCount = 0;
		int pageSize = Config.page_size;
		
		CustomerDetailInfoDAO dao = new CustomerDetailInfoDAOimpl();
		pageCount = dao.getpageCount(pageSize);
		list = dao.getnowPageData( pageSize,nowPage);
		 
		request.setAttribute("list",list );
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("nowPage", nowPage);
		RequestDispatcher rd = request.getRequestDispatcher("background/customerDetailInfoList.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
