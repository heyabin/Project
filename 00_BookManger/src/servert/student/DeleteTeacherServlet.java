package servert.student;

import impl.TeacherDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeacherDAO;

public class DeleteTeacherServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id")) ;
		TeacherDAO dao = new TeacherDAOimpl();
		String msg = "ɾ����ʦ��Ϣʧ��!";
	     String returnPath ="/FindAllTeacherServlet?nowPage=1";
		    if (dao.delete(id)) {
		    	msg = "ɾ����ʦ��Ϣ�ɹ���";
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
