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

import tool.DateConvernt;
import dao.FavoriteDAO;
import enetiy.Favorite;

public class SavefavoriteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		 int bookId = Integer.parseInt(request.getParameter("bookId"));
		 int custId = Integer.parseInt(request.getParameter("custId"));
		 String btd = request.getParameter("date");
		 Date date = DateConvernt.ConvertToDate(btd);
		 String context = request.getParameter("context"); 
		 Favorite favorite = new Favorite(bookId, custId, date, context);
		 FavoriteDAO dao = new FavoriteDAOimpl();
		 String msg = "�����ղ���Ϣʧ��!";
	     String returnPath ="background/savefavorite.jsp";
		    if (dao.save(favorite)) {
		    	msg = "�����ղ���Ϣ�ɹ���";
		    	returnPath = "/FindAllfavoriteServlet?nowPage=1";
			}
		    request.setAttribute("msg", msg);
		    request.setAttribute("returnPath", returnPath);
			RequestDispatcher rd = request.getRequestDispatcher("background/msg.jsp");
			rd.forward(request, response);
	}

}
