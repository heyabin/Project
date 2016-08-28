package servert.student;

import impl.TeacherDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeacherDAO;

import tool.Config;
import enetiy.Teacher;

public class FindAllTeacherServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int nowPage =Integer.parseInt( request.getParameter("nowPage"));
		int pageCount = 0;
		int pageSize = Config.page_size;
		List<Teacher> tea = null;
		TeacherDAO  dao = new TeacherDAOimpl();
		
		pageCount = dao.getpageCount(pageSize);
		tea = dao.getnowPageData(pageSize, nowPage);
		
		 request.setAttribute("nowPage",nowPage );
		 request.setAttribute("pageCount",pageCount);
		 request.setAttribute("tea", tea);
		 RequestDispatcher rd = request.getRequestDispatcher("background/teacherList.jsp");
		 rd.forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         this.doGet(request, response);
	}

}
