package com.cognizant.movieCruiser.servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.movieCruiser.dao.MoviesDao;
import com.cognizant.movieCruiser.dao.MoviesDaoSqlImpl;
import com.cognizant.movieCruiser.model.Movies;
/**
 * Servlet implementation class ShowMoviesListAdminServlet
 */
@WebServlet("/ShowMoviesListAdmin")
public class ShowMoviesListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowMoviesListAdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Movies> moviesList = new ArrayList<>();
		try {
			MoviesDao moviesDao = new MoviesDaoSqlImpl();
			moviesList = moviesDao.getMovieListAdmin();
			request.setAttribute("movies", moviesList);
			RequestDispatcher rd = request.getRequestDispatcher("movies-list-admin.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
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
