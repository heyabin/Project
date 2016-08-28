package servert.news;

import impl.NewDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewDAO;

import enetiy.News;

import tool.Config;

public class FindAllNewsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	 int nowPage =Integer.parseInt(request.getParameter("nowPage"));
	 int pageSize = Config.page_size;
	 int pageCount = 0;
	 List<News> news = null;
	 
	 NewDAO dao = new NewDAOimpl();
	  news= dao.getnowPageData(nowPage, pageSize);
	  pageCount	= dao.getpageCount(pageSize);
	  request.setAttribute("nowPage", nowPage);
	  request.setAttribute("pageCount",pageCount );
	  request.setAttribute("news",news);
	  RequestDispatcher rd = request.getRequestDispatcher("background/newsList.jsp");
	  rd.forward(request, response);
	 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
