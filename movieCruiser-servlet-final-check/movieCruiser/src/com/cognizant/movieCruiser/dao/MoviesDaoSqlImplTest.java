package com.cognizant.movieCruiser.dao;

import java.sql.SQLException;
import java.util.List;
import com.cognizant.movieCruiser.model.Movies;
import com.cognizant.movieCruiser.util.DateUtil;

public class MoviesDaoSqlImplTest {
	public static void main(String args[]) throws SQLException {
		testGetMovieListCustomer();
		testModifyMovie();
		testGetMovie();
		testGetMovieListAdmin();
	}

	public static void testGetMovieListAdmin() {
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		List<Movies> moviesList = moviesDao.getMovieListAdmin();
		for (Movies movies : moviesList) {
			System.out.println(movies);
		}
	}

	public static void testGetMovieListCustomer() {
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		List<Movies> moviesList = moviesDao.getMovieListCustomer();
		for (Movies movies : moviesList) {
			System.out.println(movies);
		}
	}

	public static void testModifyMovie() {
		Movies movies = new Movies(5L, "Avengers", 5750760348L, true, new DateUtil().convertToDate("02/11/2022"),
				"Superhero", true);
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		moviesDao.modifyMovie(movies);
		System.out.println("Movie List  modified successfully");
	}

	public static void testGetMovie() {
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		Movies moviesList = moviesDao.getMovie(02l);
		System.out.println(moviesList);
	}
}
