package servert.student;

import impl.StudentDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Config;

import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;

import dao.IStudentDAO;
import enetiy.Student;

public class FindAllStudentServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//------------从界面传过来的数据
		int nowPage =Integer.parseInt( request.getParameter("nowPage"));
		int pageCount = 0;
		int pageSize = Config.page_size;
		List<Student> stus = null;
		//访问数据库，获取数据
		 
		 IStudentDAO dao = new StudentDAOimpl();
		 pageCount = dao.getpageCount(pageSize);
		 stus  = dao.getnowPageData(pageSize, nowPage);
		
		 request.setAttribute("nowPage",nowPage );
		 request.setAttribute("pageCount",pageCount);
		 request.setAttribute("stus", stus);
		 
		 RequestDispatcher rd = request.getRequestDispatcher("background/ksstudentList.jsp");
		 rd.forward(request, response);
		  
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}

}
