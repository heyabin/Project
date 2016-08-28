package servert.customerDetailInfo;

import impl.BookTypeDAOimpl;
import impl.CustomerDetailInfoDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDetailInfoDAO;
import dao.IBookTypeDAO;

public class DeleteCustomerDetailInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id")) ;
		CustomerDetailInfoDAO dao = new CustomerDetailInfoDAOimpl();
		String msg = "ɾ���ͻ���Ϣʧ��!";
	     String returnPath ="/FindAllCustomerDetailInfoServlet?nowPage=1";
		    if (dao.delete(id)) {
		    	msg = "ɾ���ͻ���Ϣ�ɹ���";
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
