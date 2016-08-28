package servert.bookType;

import impl.BookTypeDAOimpl;
import impl.StudentDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.DateConvernt;
import dao.IBookTypeDAO;
import dao.IStudentDAO;
import enetiy.BookType;
import enetiy.Student;

public class UpdateBookTypeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ�ͻ��˵��������
		int bookTypeId = Integer.parseInt(request.getParameter("bookTypeId"));
		int parentId = Integer.parseInt(request.getParameter("parentId"));
		String bookTypeName = request.getParameter("bookTypeName"); 
		String context = request.getParameter("context");
		
		BookType book = new BookType(bookTypeId, parentId, bookTypeName, context);
		IBookTypeDAO dao = new BookTypeDAOimpl();
		
		String msg = "�޸�ͼ�����ʧ��!";
		String returnPath = "/FindByBookTypeIdServlet?id=" + bookTypeId;
		if (dao.modify(book)) {
			msg = "�޸�ͼ�����ɹ�!";
			returnPath ="/FindAllBookTypeServlet?nowPage=1";
		} 
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);		
		request.getRequestDispatcher("background/msg.jsp").forward(request, response);
	}

}
