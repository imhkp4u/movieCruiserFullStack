package com.cognizant.movieCruiser.dao;
import java.util.List;
import com.cognizant.movieCruiser.model.Movies;
public class FavouritesDaoCollectionImplTest {
	public static void 	testAddFavourites() throws FavouritesEmptyException {
		FavouritesDao favouritesDao = new FavouritesDaoCollectionImpl();
		favouritesDao.addFavourites(1, 2L);
		favouritesDao.addFavourites(1, 5L);
		favouritesDao.addFavourites(2, 1L);
		favouritesDao.addFavourites(2, 3L);
		@SuppressWarnings("unchecked")
		List<Movies> movieListCustomer = (List<Movies>) favouritesDao.getAllFavourites(1);
		System.out.println("User Added Movies List");
		for (Movies movies : movieListCustomer) {
			System.out.println(movies);
		}
	}
	public static void testRemoveFavourites() throws FavouritesEmptyException {
		FavouritesDao favouritesDao = new FavouritesDaoCollectionImpl();
		System.out.println("Favourites List after Remove");
		try {
			favouritesDao.removeFavourites(1, 2L);
			favouritesDao.removeFavourites(1, 5L);
			favouritesDao.removeFavourites(1, 3L);
			@SuppressWarnings("unchecked")
			List<Movies> moviesListCustomer = (List<Movies>) favouritesDao.getAllFavourites(1);
			for (Movies movies : moviesListCustomer) {
				System.out.println(movies);
			}
		} catch (FavouritesEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	// public static void testGetAllFavourites() {
	// }
	public static void main(String[] args) throws FavouritesEmptyException {
		testAddFavourites();
		testRemoveFavourites();
	}
}
