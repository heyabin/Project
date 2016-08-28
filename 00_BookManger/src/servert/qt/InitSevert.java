package servert.qt;

import impl.BookInfoDAOimpl;
import impl.BookTypeDAOimpl;
import impl.NewDAOimpl;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IBookInforDAO;
import dao.IBookTypeDAO;
import dao.NewDAO;
import enetiy.BookInfo;
import enetiy.BookType;
import enetiy.News;

public class InitSevert extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<News> listNews = null;
		List<BookInfo> zxBooks  = null;
		List<BookInfo> rxBooks  = null;
		List<BookInfo> tjBooks  = null;
		NewDAO newDAO = new NewDAOimpl();
		listNews  = newDAO.findFbTime(9);
		
		IBookInforDAO bookInforDAO = new BookInfoDAOimpl(); 
		zxBooks = bookInforDAO.findBySjDate(5);
		rxBooks = bookInforDAO.findBySaleCount(5);
		tjBooks = bookInforDAO.findAll();
		
		//�ϰ���bookType,������sonBookTypes
		Map<BookType,List<BookType>> maps = new Hashtable<BookType, List<BookType>>();
		//�ȵõ��ϰֵı��parentBookgetParentId  
		IBookTypeDAO bookTypeDAO = new BookTypeDAOimpl();
		List<BookType> parentBookgetParentId  = bookTypeDAO.findByParentId(0);
		//�ȵõ����и������
		//Ȼ��������и�����𣬵õ�ÿһ���������1,2
		//Ȼ�����ÿ���ϰֵ��µĶ��ӱ��sonBookType��1����������5������
		for (BookType bookType : parentBookgetParentId) {
			List<BookType> sonBookTypes = bookTypeDAO.findByParentId(bookType.getBookTypeId());
			maps.put(bookType, sonBookTypes);
		}
		request.setAttribute("listNews", listNews);
		request.setAttribute("zxBooks", zxBooks);
		request.setAttribute("rxBooks", rxBooks);
		request.setAttribute("tjBooks", tjBooks);
		request.setAttribute("maps", maps);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
