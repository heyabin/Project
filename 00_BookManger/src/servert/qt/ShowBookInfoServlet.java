package servert.qt;

import impl.BookDiscussDAOimpl;
import impl.BookInfoDAOimpl;
import impl.BookTypeDAOimpl;
import impl.StudentDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Config;

import dao.BookDiscussDAO;
import dao.IBookInforDAO;
import dao.IBookTypeDAO;
import dao.IStudentDAO;

import enetiy.BookDiscuss;
import enetiy.BookInfo;
import enetiy.BookType;

public class ShowBookInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BookInfo bookInfo = null;
		List<BookInfo> rxBooks  = null;
		List<BookDiscuss> bookDiscusses = null;
		
		//我们需要商品分类
		Map<BookType,List<BookType>> maps = new Hashtable<BookType, List<BookType>>();
		IBookTypeDAO bookTypeDAO = new BookTypeDAOimpl();
		List<BookType> parentBookgetParentId  = bookTypeDAO.findByParentId(0);
		for (BookType bookType : parentBookgetParentId) {
			List<BookType> sonBookTypes = bookTypeDAO.findByParentId(bookType.getBookTypeId());
			maps.put(bookType, sonBookTypes);
		}
		//商品详细信息
		IBookInforDAO bookInforDAO = new BookInfoDAOimpl();
		bookInfo = bookInforDAO.findById(id);
		//最新排行
		rxBooks = bookInforDAO.findBySaleCount(5);
		//商品评价
		BookDiscussDAO bookDiscussDAO = new BookDiscussDAOimpl();
		bookDiscusses = bookDiscussDAO.findById(id);
		
		request.setAttribute("bookDiscusses", bookDiscusses);
		request.setAttribute("bookInfo", bookInfo);
		request.setAttribute("rxBooks", rxBooks);
		request.setAttribute("maps", maps);
		request.getRequestDispatcher("bookInfo.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
