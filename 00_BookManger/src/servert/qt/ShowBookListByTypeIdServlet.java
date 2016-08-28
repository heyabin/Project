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

import tool.Config;

import dao.BookDiscussDAO;
import dao.IBookInforDAO;
import dao.IBookTypeDAO;
import dao.NewDAO;
import enetiy.BookDiscuss;
import enetiy.BookInfo;
import enetiy.BookType;
import enetiy.News;

public class ShowBookListByTypeIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int booktypeId =Integer.parseInt(request.getParameter("booktypeId"));
		int nowPage = Integer.parseInt( request.getParameter("nowPage"));
		int pageCount = 0;
		int pageSize = Config.page_size;
		
		List<BookInfo> rxBooks  = null;
		List<BookDiscuss> bookDiscusses = null;
		Map<BookType,List<BookType>> maps = new Hashtable<BookType, List<BookType>>();
		
		//���ҵڶ��η�����µľ�����Ʒ��ϸ��Ϣ����ʫ�������6�����й��Ŵ�С˵������8��������С˵��5��
		List<BookInfo>  bookInfos = null;
		IBookInforDAO bookInfoDAO = new BookInfoDAOimpl();
		pageCount = bookInfoDAO.getpageCount2(pageSize,booktypeId);
		bookInfos  = bookInfoDAO.getnowPageData2(pageSize, nowPage, booktypeId);
				
		//������Ҫ��Ʒ����
		IBookTypeDAO bookTypeDAO = new BookTypeDAOimpl();
		List<BookType> parentBookgetParentId  = bookTypeDAO.findByParentId(0);
		for (BookType bookType : parentBookgetParentId) {
			List<BookType> sonBookTypes = bookTypeDAO.findByParentId(bookType.getBookTypeId());
			maps.put(bookType, sonBookTypes);
		}
		//��������----����books
		IBookInforDAO bookInforDAO = new BookInfoDAOimpl();
		rxBooks = bookInforDAO.findBySaleCount(5);
		//��Ʒ����
		BookDiscussDAO bookDiscussDAO = new BookDiscussDAOimpl();
		
		request.setAttribute("rxBooks", rxBooks);
		request.setAttribute("maps", maps);
		
		
		 request.setAttribute("nowPage",nowPage );
		 request.setAttribute("pageCount",pageCount);
		 request.setAttribute("bookInfos", bookInfos);
		 request.setAttribute("booktypeId", booktypeId);
		 request.getRequestDispatcher("bookInfoList.jsp").forward(request, response); 
		 
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}

}
