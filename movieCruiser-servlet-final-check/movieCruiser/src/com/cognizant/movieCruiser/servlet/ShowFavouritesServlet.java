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
import com.cognizant.movieCruiser.model.Favourites;

/**
 * Servlet implementation class ShowFavouritesServlet
 */
@WebServlet("/ShowFavourites")
public class ShowFavouritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowFavouritesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long userId = 1l;
		FavouritesDao favouritesDao = new FavouritesDaoSqlImpl();
		try {
			Favourites favourites = favouritesDao.getAllFavourites(userId);
			request.setAttribute("favourites", favourites);
			System.out.println("-----");
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