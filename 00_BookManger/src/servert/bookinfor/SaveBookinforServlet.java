package servert.bookinfor;

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

public class SaveBookinforServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取客户端的请求参数
		request.setCharacterEncoding("gbk");
		String bookName = request.getParameter("bookName");
		int bookTypeId = Integer.parseInt(request.getParameter("bookTypeId"));
		String author = request.getParameter("author");
		String pbName = request.getParameter("pbName");
		String context = request.getParameter("context");
		String smallImg = request.getParameter("smallImg");
		String bigImg = request.getParameter("bigImg");
		int price = Integer.parseInt(request.getParameter("price"));
		
		String bdate = request.getParameter("pbdate"); 
		Date pbdate = DateConvernt.ConvertToDate(bdate);
		
		int hyprice = Integer.parseInt(request.getParameter("hyprice"));
		int bookStates = Integer.parseInt(request.getParameter("bookStates"));
		
		String datet = request.getParameter("datetime"); 
		Date datetime = DateConvernt.ConvertToDate(datet);
		
		int num = Integer.parseInt(request.getParameter("num"));
		int saleCount = Integer.parseInt(request.getParameter("saleCount"));
		
		BookInfo bookType = new BookInfo(bookName, bookTypeId, author, pbName, context, smallImg, bigImg, price, pbdate, hyprice,
				bookStates, datetime, num, saleCount);
 		IBookInforDAO dao = new BookInfoDAOimpl();
		 String msg = "新增学生信息失败!";
	     String returnPath ="background/saveBookinfor.jsp";
		    if (dao.save(bookType)) {
		    	msg = "新增学生信息成功！";
		    	returnPath = "/FindAllBookinforServlet?nowPage=1";
			}
		    request.setAttribute("msg", msg);
		    request.setAttribute("returnPath", returnPath);
			RequestDispatcher rd = request.getRequestDispatcher("background/msg.jsp");
			rd.forward(request, response);

	}

}
