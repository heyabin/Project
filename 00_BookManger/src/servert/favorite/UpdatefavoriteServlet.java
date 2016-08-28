package servert.favorite;

import impl.FavoriteDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FavoriteDAO;

import enetiy.Favorite;

import tool.Config;
import tool.DateConvernt;

public class UpdatefavoriteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	request.setCharacterEncoding("gbk");
		int favoriteId = Integer.parseInt(request.getParameter("favoriteId"));
		 int bookId = Integer.parseInt(request.getParameter("bookId"));
		 int custId = Integer.parseInt(request.getParameter("custId"));
		 String btd = request.getParameter("date");
		 Date date = DateConvernt.ConvertToDate(btd);
		 String context = request.getParameter("context"); 
		 Favorite favorite = new Favorite(favoriteId, bookId, custId, date, context);
		 FavoriteDAO dao = new FavoriteDAOimpl();
		 String msg = "修改收藏信息失败!";
	     String returnPath ="background/FindByfavoriteIdServlet?id=" + favoriteId;
		    if (dao.modify(favorite)) {
		    	msg = "修改收藏信息成功！";
		    	returnPath = "/FindAllfavoriteServlet?nowPage=1";
			}
		    request.setAttribute("msg", msg);
		    request.setAttribute("returnPath", returnPath);
			RequestDispatcher rd = request.getRequestDispatcher("background/msg.jsp");
			rd.forward(request, response);

	}

}
