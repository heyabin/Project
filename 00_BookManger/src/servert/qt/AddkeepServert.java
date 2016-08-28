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

import dao.FavoriteDAO;

import tool.Config;
import tool.DateConvernt;

import enetiy.CustomerInfo;
import enetiy.Favorite;

public class AddkeepServert extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  
		HttpSession session = request.getSession();
	        //Ã»ÓÐµÇÂ¼
	        if (session.getAttribute("customerInfo")== null) {
	        	response.sendRedirect("qtlogin.jsp");
			//µÇÂ¼ÁË
			}else {
				CustomerInfo customerInfo = (CustomerInfo)session.getAttribute("customerInfo");
				int custId = customerInfo.getCustId();
				int id = Integer.parseInt(request.getParameter("id")); 
				String btdStr = request.getParameter("date");
				Date date = new Date();
			    //String btd = DateConvernt.ConvertToString(date);
			    String context = null;
			    Favorite favorite = new Favorite(id, custId, date, context);
			    FavoriteDAO dao = new FavoriteDAOimpl();
			    if (dao.save(favorite)) {
			    	System.out.println(dao.save(favorite));
			    	response.sendRedirect("background/success.jsp");
				}
				   
				   
			    
			    
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
