package servert.customerDetailInfo;

import impl.BookTypeDAOimpl;
import impl.CustomerDetailInfoDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDetailInfoDAO;
import dao.IBookTypeDAO;
import enetiy.BookType;
import enetiy.CustomerDetailInfo;

public class UpdateCustomerDetailInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ�ͻ��˵��������
		
		int custId = Integer.parseInt(request.getParameter("custId"));
		String tel = request.getParameter("tel"); 
		String address = request.getParameter("address");
		int sex = Integer.parseInt(request.getParameter("sex"));
		int age = Integer.parseInt(request.getParameter("age"));
		int countMoney = Integer.parseInt(request.getParameter("countMoney"));
		int qq = Integer.parseInt(request.getParameter("qq"));
		CustomerDetailInfo book = new CustomerDetailInfo(custId, tel, address, sex, age, countMoney, qq);
		CustomerDetailInfoDAO dao = new CustomerDetailInfoDAOimpl();
		
		String msg = "�޸Ŀͻ���ϸ��Ϣʧ��!";
		String returnPath = "/FindByCustomerDetailInfoIdServlet?id=" + custId;
		if (dao.modify(book)) {
			msg = "�޸Ŀͻ���ϸ��Ϣ�ɹ�!";
			returnPath ="/FindAllCustomerDetailInfoServlet?nowPage=1";
		} 
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);		
		request.getRequestDispatcher("background/msg.jsp").forward(request, response);
	}

}
