package com.cognizant.movieCruiser.dao;

public class FavouritesEmptyException extends Exception {
	private static final long serialVersionUID = 1L;

	public FavouritesEmptyException() {
		super("Favourites is Empty");
	}
}