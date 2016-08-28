package servert.bookType;

import impl.BookTypeDAOimpl;
import impl.StudentDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IBookTypeDAO;
import dao.IStudentDAO;

public class DeleteBookTypeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id")) ;
		IBookTypeDAO dao = new BookTypeDAOimpl();
		String msg = "ɾ��ѧ����Ϣʧ��!";
	     String returnPath ="/FindAllBookTypeServlet?nowPage=1";
		    if (dao.delete(id)) {
		    	msg = "ɾ��ѧ����Ϣ�ɹ���";
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
