package servert.qt;

import impl.BookDiscussDAOimpl;
import impl.BookInfoDAOimpl;
import impl.BookTypeDAOimpl;
import impl.NewDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDiscussDAO;
import dao.IBookInforDAO;
import dao.IBookTypeDAO;
import dao.NewDAO;

import enetiy.BookDiscuss;
import enetiy.BookInfo;
import enetiy.BookType;
import enetiy.News;

public class ShowNewsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<BookDiscuss> bookDiscusses = null;
		List<BookInfo> rxBooks  = null;
		List<BookDiscuss> bookDiscusse = null;
		
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
		//最新排行
		rxBooks = bookInforDAO.findBySaleCount(5);
		//商品评价
		BookDiscussDAO bookDiscussDAO = new BookDiscussDAOimpl();
		bookDiscusses = bookDiscussDAO.findById(id);
		NewDAO dao = new NewDAOimpl();
		News news = dao.find(id);
		request.setAttribute("bookDiscusses", bookDiscusses);
		request.setAttribute("rxBooks", rxBooks);
		request.setAttribute("maps", maps);
	    request.setAttribute("news", news);
		  RequestDispatcher rd = request.getRequestDispatcher("ShowNews.jsp");
		  rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
