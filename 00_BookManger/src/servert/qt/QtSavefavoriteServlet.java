package servert.qt;

import impl.FavoriteDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.DateConvernt;
import dao.FavoriteDAO;
import enetiy.CustomerInfo;
import enetiy.Favorite;

public class QtSavefavoriteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		
		HttpSession session = request.getSession();
		CustomerInfo customerInfo = (CustomerInfo)session.getAttribute("customerInfo");
		//客户编号
		int custId = customerInfo.getCustId();
		//图书编号
		int bookId= Integer.parseInt(request.getParameter("bookId")); 
		String btd = request.getParameter("date");
		Date date  = DateConvernt.ConvertToDate(btd);
	   String context = request.getParameter("context"); 
		 Favorite favorite = new Favorite(bookId, custId, date, context);
		 FavoriteDAO dao = new FavoriteDAOimpl();
		 String msg = "新增收藏信息失败!";
	     String returnPath ="qtsavefavorite.jsp";
		    if (dao.save(favorite)) {
		    	msg = "新增收藏信息成功！";
		    	returnPath = "/FindAllfavoriteServlet?nowPage=1";
			}
		    request.setAttribute("msg", msg);
		    request.setAttribute("returnPath", returnPath);
			RequestDispatcher rd = request.getRequestDispatcher("background/msg.jsp");
			rd.forward(request, response);
	
	}

}
