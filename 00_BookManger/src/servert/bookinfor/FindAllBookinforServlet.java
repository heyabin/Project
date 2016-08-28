package servert.bookinfor;

import impl.BookInfoDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Config;

import dao.IBookInforDAO;
import enetiy.BookInfo;

public class FindAllBookinforServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.setCharacterEncoding("gbk");
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		//当前页的具体数据
		List<BookInfo> list = null;
		int pageCount = 0;
		int pageSize = Config.page_size;
		
		IBookInforDAO dao = new BookInfoDAOimpl();
		pageCount = dao.getpageCount(pageSize);
		list = dao.getnowPageData( pageSize,nowPage);
		 
		request.setAttribute("list",list );
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("nowPage", nowPage);
		RequestDispatcher rd = request.getRequestDispatcher("background/bookinforList.jsp");
		rd.forward(request, response);
		  
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}

}
