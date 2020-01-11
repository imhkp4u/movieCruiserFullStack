package com.cognizant.movieCruiser.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.cognizant.movieCruiser.model.Movies;
import com.cognizant.movieCruiser.util.DateUtil;

public class MoviesDaoCollectionImpl implements MoviesDao {
	private static List<Movies> movieList;

	public MoviesDaoCollectionImpl() {
		super();
		if (movieList == null) {
			movieList = new ArrayList<Movies>();
			Movies itemOne = new Movies(1L, "Avatar", 2787965087L, true, new DateUtil().convertToDate("15/03/2017"),
					"Science Fiction", true);

			Movies itemTwo = new Movies(2L, "The Avengers", 1518812988L, true,
					new DateUtil().convertToDate("23/12/2017"), "Superhero", false);

			Movies itemThree = new Movies(3L, "Titanic", 2187463944L, true, new DateUtil().convertToDate("21/08/2020"),
					"Romance", false);

			Movies itemFour = new Movies(4L, "Jurassic World", 1671713208L, false,
					new DateUtil().convertToDate("02/07/2017"), "Science Fiction", true);

			Movies itemFive = new Movies(5L, "Avengers", 2750760348L, true, new DateUtil().convertToDate("02/11/2022"),
					"Superhero", true);
			movieList.add(itemOne);
			movieList.add(itemTwo);
			movieList.add(itemThree);
			movieList.add(itemFour);
			movieList.add(itemFive);
		}
	}

	@Override
	public List<Movies> getMovieListAdmin() {
		return movieList;
	}

	@Override
	public List<Movies> getMovieListCustomer() {
		ArrayList<Movies> filteredMovies = new ArrayList<Movies>();
		for (Movies movies : movieList) {
			if (movies.getDateOfLaunch().after(new Date())) {
				if (movies.getActive()) {
					filteredMovies.add(movies);
				}
			}
		}
		return filteredMovies;
	}

	@Override
	public void modifyMovie(Movies movies) {
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movies.getId()) {
				movieList.set(i, movies);
			}
		}
	}

	@Override
	public Movies getMovie(Long moviesId) {
		for (Movies movies : movieList) {
			if (movies.getId() == moviesId) {
				return movies;
			}
		}
		return null;
	}
}