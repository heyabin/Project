package servert.student;

import impl.HomeworkDAOimpl;
import impl.StudentDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HomeworkDAO;
import enetiy.Homework;

import tool.DateConvernt;

public class SaveHomeworkServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		int homeId = Integer.parseInt(request.getParameter("homeId"));
		String homeName = request.getParameter("homeName");
		String homecontext = request.getParameter("homecontext");
		String homedate = request.getParameter("homesumbmit"); 
		Date homesumbmit = DateConvernt.ConvertToDate(homedate);
		int homegrade = Integer.parseInt(request.getParameter("homegrade"));
		String author = request.getParameter("author");
		Homework homework = new Homework(homeId, homeName, homecontext, homesumbmit, homegrade, author);
		HomeworkDAO dao = new HomeworkDAOimpl();
            		
		 String msg = "新增作业信息失败!";
	     String returnPath ="background/kssaveHomework.jsp";
		    if (dao.save(homework)) {
		    	msg = "新增作业信息成功！";
		    	returnPath = "/FindAllHomeworkServlet?nowPage=1";
			}
		    request.setAttribute("msg", msg);
		    request.setAttribute("returnPath", returnPath);
			RequestDispatcher rd = request.getRequestDispatcher("background/msg.jsp");
			rd.forward(request, response);
	
		
		
	}

}
