package servert.student;

import impl.HomeworkDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.HomeworkDAO;
import enetiy.Homework;
import tool.Config;

public class FindAllHomeworkServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int nowPage =Integer.parseInt( request.getParameter("nowPage"));
		int pageCount = 0;
		int pageSize = Config.page_size;
		List<Homework> home = null;
		
		HomeworkDAO dao = new HomeworkDAOimpl();
		pageCount = dao.getpageCount(pageSize);
		home = dao.getnowPageData(nowPage, pageSize);
		
		
		request.setAttribute("nowPage",nowPage );
		request.setAttribute("pageCount",pageCount);
		request.setAttribute("home", home);
		RequestDispatcher rd = request.getRequestDispatcher("background/kshomeworkList.jsp");
	    rd.forward(request, response);
	    
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   this.doGet(request, response);

	}

}
