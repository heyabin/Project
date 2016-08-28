package servert.bookinfor;

import impl.BookInfoDAOimpl;
import impl.StudentDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IBookInforDAO;
import dao.IStudentDAO;
import enetiy.BookInfo;

import tool.DateConvernt;

public class UpdateBookinforServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 this.doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		int bookId = Integer.parseInt(request.getParameter("bookId"));
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

		BookInfo bookType = new BookInfo(bookId,bookName, bookTypeId, author, pbName, context, smallImg, bigImg, price, pbdate, hyprice,
				bookStates, datetime, num, saleCount);
		

 		IBookInforDAO dao = new BookInfoDAOimpl();
		String msg = "修改学生信息失败!";
		String returnPath = "/FindByBookinforIdServlet?id=" + bookId;
		if (dao.modify(bookType)) {
			msg = "修改学生信息成功!";
			returnPath ="/FindAllBookinforServlet?nowPage=1";
		} 
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);		
		request.getRequestDispatcher("background/msg.jsp").forward(request, response);
	}

}
