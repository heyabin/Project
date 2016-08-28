package servert.bookType;

import impl.BookTypeDAOimpl;
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
import dao.IBookTypeDAO;
import dao.IStudentDAO;
import enetiy.BookType;
import enetiy.Student;

public class SaveBookTypeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int parentId = Integer.parseInt(request.getParameter("parentId"));
		String bookTypeName = request.getParameter("bookTypeName"); 
		String context = request.getParameter("context");
		
		BookType stu = new BookType(parentId, bookTypeName, context);
		IBookTypeDAO dao = new BookTypeDAOimpl();
		 String msg = "新增图书类别失败!";
	     String returnPath ="background/savebookType.jsp";
		    if (dao.save(stu)) {
		    	msg = "新增学生信息成功！";
		    	returnPath = "/FindAllBookTypeServlet?nowPage=1";
			}
		    request.setAttribute("msg", msg);
		    request.setAttribute("returnPath", returnPath);
			RequestDispatcher rd = request.getRequestDispatcher("background/msg.jsp");
			rd.forward(request, response);

	}

}
