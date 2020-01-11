package com.cognizant.movieCruiser.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.movieCruiser.dao.FavouritesDao;
import com.cognizant.movieCruiser.dao.FavouritesDaoSqlImpl;
import com.cognizant.movieCruiser.dao.MoviesDao;
import com.cognizant.movieCruiser.dao.MoviesDaoSqlImpl;
import com.cognizant.movieCruiser.model.Movies;

/**
 * Servlet implementation class AddToFavouritesServlet
 */
@WebServlet("/AddToFavourites")
public class AddToFavouritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToFavouritesServlet() {
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
		long moviesId = Long.parseLong(request.getParameter("id"));
		FavouritesDao favouritesDao = new FavouritesDaoSqlImpl();
		favouritesDao.addFavourites(userId, moviesId);
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		List<Movies> moviesListCustomer = moviesDao.getMovieListCustomer();
		request.setAttribute("moviesList", moviesListCustomer);
		request.setAttribute("addFavouritesStatus", true);
		request.getRequestDispatcher("movies-list-customer.jsp").forward(request, response);
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