package com.cognizant.movieCruiser.dao;

import com.cognizant.movieCruiser.model.Favourites;

public class FavouritesDaoSqlImplTest {
	public static void main(String args[]) throws FavouritesEmptyException {
		testAddFavorite();
		testGetAllFavourites();
		// testRemoveFavourite();
	}

	public static void testAddFavorite() {
		FavouritesDaoSqlImpl favouriteDaoSqlImpl = new FavouritesDaoSqlImpl();
		favouriteDaoSqlImpl.addFavourites(1L, 2L);
		System.out.println("Movie Added to favoruites Successfully");
	}

	public static void testGetAllFavourites() throws FavouritesEmptyException {
		FavouritesDaoSqlImpl favouriteDaoSqlImpl = new FavouritesDaoSqlImpl();
		Favourites favourites = favouriteDaoSqlImpl.getAllFavourites(1l);
		System.out.println("Movie List: " + favourites.getMovieList());
		System.out.println("Favourite Count: " + favourites.getTotal());
	}

	public static void testRemoveFavourite() {
		FavouritesDaoSqlImpl favouriteDaoSqlImpl = new FavouritesDaoSqlImpl();
		favouriteDaoSqlImpl.removeFavourites(1L, 2L);
		System.out.println("Movie removed from favourites successfully");
	}
}
