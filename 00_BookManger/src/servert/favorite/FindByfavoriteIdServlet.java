package servert.favorite;

import impl.FavoriteDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FavoriteDAO;
import enetiy.Favorite;

public class FindByfavoriteIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id")); 
		FavoriteDAO dao = new FavoriteDAOimpl();
		Favorite favorite =  dao.findById(id);
		request.setAttribute("favorite", favorite);
		RequestDispatcher rd = request.getRequestDispatcher("background/updatefavorite.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
