package servert.bookType;

import impl.BookInfoDAOimpl;
import impl.BookTypeDAOimpl;

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
import dao.IBookTypeDAO;
import enetiy.BookInfo;
import enetiy.BookType;

public class FindAllBookTypeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		//当前页的具体数据
		List<BookType> list = null;
		int pageCount = 0;
		int pageSize = Config.page_size;
		
		IBookTypeDAO dao = new BookTypeDAOimpl();
		pageCount = dao.getpageCount(pageSize);
		list = dao.getnowPageData( pageSize,nowPage);
		 
		request.setAttribute("list",list );
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("nowPage", nowPage);
		RequestDispatcher rd = request.getRequestDispatcher("background/bookTypeList.jsp");
		rd.forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
