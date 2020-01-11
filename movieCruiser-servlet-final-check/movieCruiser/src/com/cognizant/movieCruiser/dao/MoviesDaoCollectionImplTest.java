package com.cognizant.movieCruiser.dao;

import java.util.List;
import com.cognizant.movieCruiser.model.Movies;
import com.cognizant.movieCruiser.util.DateUtil;

public class MoviesDaoCollectionImplTest {
	public static void testGetMoviesListAdmin() {
		System.out.println("Item List for Admin");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> moviesList = moviesDao.getMovieListAdmin();
		for (Movies movies : moviesList) {
			System.out.println(movies);
		}
	}

	public static void testGetMoviesListCustomer() {
		System.out.println("Movies List for Customer");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> moviesList = moviesDao.getMovieListCustomer();
		for (Movies movies : moviesList) {
			System.out.println(movies);
		}
	}

	public static void testModifyMovies() {
		// Long id, String title, String gross, Boolean active, Date dateOfLaunch,
		// String genre,Boolean hasTeaser
		Movies movie = new Movies(5L, "Avengers", 5750760348L, true, new DateUtil().convertToDate("02/11/2022"),
				"Superhero", true);
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		moviesDao.modifyMovie(movie);
		System.out.println("*** Modified Movies List***");
		testGetMoviesListAdmin();
		Movies modified_movie = moviesDao.getMovie(movie.getId());
		System.out.println("Modified Item details\n" + modified_movie);
	}

	public static void main(String[] args) {
		testGetMoviesListAdmin();
		testGetMoviesListCustomer();
		testModifyMovies();
	}
}
