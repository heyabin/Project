package servert.favorite;

import impl.FavoriteDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FavoriteDAO;

import enetiy.Favorite;

import tool.Config;

public class FindAllfavoriteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
     int nowPage = Integer.parseInt(request.getParameter("nowPage"));
     int pageSize = Config.page_size;
     int pageCount = 0;
     List<Favorite> list = null;
     FavoriteDAO dao = new FavoriteDAOimpl();
     pageCount =  dao.getnowPage(pageSize);
     list = dao.getnowPageDate(pageSize, nowPage);
 	request.setAttribute("list",list );
 	request.setAttribute("pageCount", pageCount);
    request.setAttribute("nowPage",nowPage );
    RequestDispatcher rd = request.getRequestDispatcher("background/favoriteList.jsp");
	  rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
