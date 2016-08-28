package servert.student;

import impl.StudentDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IStudentDAO;

public class DeleteStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id")) ;
		IStudentDAO dao = new StudentDAOimpl();
		String msg = "删除学生信息失败!";
	     String returnPath ="/FindAllStudentServlet?nowPage=1";
		    if (dao.delete(id)) {
		    	msg = "删除学生信息成功！";
			}
		    request.setAttribute("msg", msg);
		    request.setAttribute("returnPath", returnPath);
			RequestDispatcher rd = request.getRequestDispatcher("background/msg.jsp");
			rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	          this.doGet(request, response);
	}

}
