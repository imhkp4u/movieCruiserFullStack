package com.cognizant.movieCruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.cognizant.movieCruiser.model.Favourites;
import com.cognizant.movieCruiser.model.Movies;

public class FavouritesDaoCollectionImpl implements FavouritesDao {
	private static HashMap<Long, Favourites> userFavourites;

	public FavouritesDaoCollectionImpl() {
		super();
		if (userFavourites == null) {
			userFavourites = new HashMap<>();
		}
	}

	@Override
	public void addFavourites(long userId, long moviesId) {
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		Movies movies = moviesDao.getMovie(moviesId);
		if (userFavourites.containsKey(userId)) {
			userFavourites.get(userId).getMovieList().add(movies);
		} else {
			Favourites favourites = new Favourites();
			ArrayList<Movies> movieList = new ArrayList<>();
			movieList.add(movies);
			favourites.setMovieList(movieList);
			userFavourites.put(userId, favourites);
		}
	}

	@Override
	public Favourites getAllFavourites(long userId) throws FavouritesEmptyException {
		Favourites favourites = userFavourites.get(userId);
		int total = 0;
		if (favourites == null || favourites.getMovieList().isEmpty()) {
			throw new FavouritesEmptyException();
		}
		List<Movies> movieList = favourites.getMovieList();
		for (@SuppressWarnings("unused")
		Movies movies : movieList) {
			total++;
		}
		favourites.setTotal((int) total);
		return favourites;
	}

	@Override
	public void removeFavourites(long userID, long moviesId) {
		List<Movies> movieList = userFavourites.get(userID).getMovieList();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == moviesId) {
				movieList.remove(i);
				return;
			}
		}
	}
}