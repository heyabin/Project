package servert.student;

import impl.TeacherDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.DateConvernt;
import dao.TeacherDAO;
import enetiy.Teacher;

public class UpdateTeacherServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int teaId= Integer.parseInt(request.getParameter("teaId"));
		String teaName = request.getParameter("teaName");
		int teaAge= Integer.parseInt(request.getParameter("teaAge"));
		String btdStr = request.getParameter("teaBtd"); 
		Date teaBtd = DateConvernt.ConvertToDate(btdStr);
		int sex = Integer.parseInt(request.getParameter("teaSex"));
		boolean teaSex = (sex == 1);
		String teaTel = request.getParameter("teaTel");
		String teaaddress = request.getParameter("teaaddress");
		Teacher teacher = new Teacher(teaName, teaAge, teaBtd, teaSex, teaTel, teaaddress);
		TeacherDAO dao = new TeacherDAOimpl();
		teacher.setTeaId(teaId);
		 String msg = "修改老师信息失败!";
	     String returnPath ="background/updateTeacher.jsp";
		    if (dao.modefy(teacher)) {
		    	msg = "修改老师信息成功！";
		    	returnPath = "/FindAllTeacherServlet?nowPage=1";
			}
		    request.setAttribute("msg", msg);
		    request.setAttribute("returnPath", returnPath);
			RequestDispatcher rd = request.getRequestDispatcher("background/msg.jsp");
			rd.forward(request, response);
		
	}

}
