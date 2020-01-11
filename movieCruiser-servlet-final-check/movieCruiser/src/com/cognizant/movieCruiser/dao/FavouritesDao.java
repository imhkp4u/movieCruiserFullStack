package com.cognizant.movieCruiser.dao;

import com.cognizant.movieCruiser.model.Favourites;

public interface FavouritesDao {
	public void addFavourites(long userId, long moviesId);

	public Favourites getAllFavourites(long userId) throws FavouritesEmptyException;

	public void removeFavourites(long userID, long moviesId);
}
