package com.cognizant.movieCruiser.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.movieCruiser.dao.MoviesDao;
import com.cognizant.movieCruiser.dao.MoviesDaoSqlImpl;
import com.cognizant.movieCruiser.model.Movies;

/**
 * Servlet implementation class ShowEditMoviesServlet
 */
@WebServlet("/ShowEditMovies")
public class ShowEditMoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowEditMoviesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		Long moviesId = Long.parseLong(request.getParameter("id"));
		Movies movies = moviesDao.getMovie(moviesId);
		request.setAttribute("movies", movies);
		request.getRequestDispatcher("edit-movies.jsp").forward(request, response);
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