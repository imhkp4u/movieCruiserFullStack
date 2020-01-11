package com.cognizant.movieCruiser.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.movieCruiser.dao.FavouritesDao;
import com.cognizant.movieCruiser.dao.FavouritesDaoSqlImpl;
import com.cognizant.movieCruiser.dao.FavouritesEmptyException;

/**
 * Servlet implementation class RemoveFavouritesServlet
 */
@WebServlet("/RemoveFavourites")
public class RemoveFavouritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveFavouritesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long userId = 1l;
		Long moviesId = Long.parseLong(request.getParameter("id"));
		FavouritesDao favouritesDao = new FavouritesDaoSqlImpl();
		favouritesDao.removeFavourites(1, moviesId);
		try {
			request.setAttribute("favourites", favouritesDao.getAllFavourites(userId));
			request.setAttribute("message", true);
			request.getRequestDispatcher("favourites.jsp").forward(request, response);
		} catch (FavouritesEmptyException e) {
			request.getRequestDispatcher("favourites-empty.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}