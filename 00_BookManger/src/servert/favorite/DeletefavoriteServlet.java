package servert.favorite;

import impl.FavoriteDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FavoriteDAO;
import enetiy.Favorite;

public class DeletefavoriteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id")); 
		 FavoriteDAO dao = new FavoriteDAOimpl();
		 String msg = "删除收藏信息";
			String   returnPath  = "/FindAllfavoriteServlet?nowPage = 1";
			if (dao.delete(id)) {
				msg = "删除收藏信息成功!";
				returnPath ="/FindAllfavoriteServlet?nowPage=1";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("returnPath", returnPath);		
			request.getRequestDispatcher("background/msg.jsp").forward(request, response);
		 
		 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
