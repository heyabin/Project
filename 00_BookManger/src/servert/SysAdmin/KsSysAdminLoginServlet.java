package servert.SysAdmin;

import impl.SysAdminDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SysAdminDAO;
import enetiy.SysAdmin;

public class KsSysAdminLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gbk");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		SysAdminDAO dao = new SysAdminDAOimpl();
		SysAdmin sysAdmin =  dao.findNameAndPwd(name, pwd);
		String path = "kslogin.jsp";
		if (sysAdmin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("sysAdmin",sysAdmin );
			 path = "ksindex.jsp";
		}
		response.sendRedirect("background/"+ path);	
	}
	
}
