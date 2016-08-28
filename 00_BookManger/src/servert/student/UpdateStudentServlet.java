package servert.student;

import impl.BookInfoDAOimpl;
import impl.StudentDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.DateConvernt;
import dao.IBookInforDAO;
import dao.IStudentDAO;
import enetiy.BookInfo;
import enetiy.Student;

public class UpdateStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		// 获取客户端的请求参数
		int stuId = Integer.parseInt(request.getParameter("stuId"));
		String stuName = request.getParameter("stuName");
		int stuAge = Integer.parseInt(request.getParameter("stuAge"));
		String btdStr = request.getParameter("stuBtd");
		Date stuBtd = DateConvernt.ConvertToDate(btdStr);
		int sex = Integer.parseInt(request.getParameter("stuSex"));
		boolean stuSex = (sex == 1);
		String stuTel = request.getParameter("stuTel");

		Student stu = new Student(stuName, stuAge, stuBtd, stuSex, stuTel);
		stu.setStuId(stuId);
		
		IStudentDAO studentDAO = new StudentDAOimpl();
		String msg = "修改学生信息失败!";
		String returnPath = "/FindByStudentIdServlet?id=" + stuId;
		if (studentDAO.modefy(stu)) {
			msg = "修改学生信息成功!";
			returnPath ="/FindAllStudentServlet?nowPage=1";
		} 
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);		
		request.getRequestDispatcher("background/msg.jsp").forward(request, response);
	}
}