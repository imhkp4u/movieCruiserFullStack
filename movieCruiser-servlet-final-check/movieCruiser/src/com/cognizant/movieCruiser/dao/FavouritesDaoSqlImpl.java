package com.cognizant.movieCruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cognizant.movieCruiser.model.Favourites;
import com.cognizant.movieCruiser.model.Movies;

public class FavouritesDaoSqlImpl implements FavouritesDao {
	public static final String ADD_MOVIES_TO_FAVORITE = "insert into favorites(fav_us_id, fav_mov_id) values(?,?)";
	public static final String GET_MOVIES_FROM_FAVORITE = "select * from movies inner join favorites on fav_mov_id = mov_id where fav_us_id = ?";
	public static final String GET_TOTAL_FAVORITE = "select count(fav_id) as Total from movies inner join favorites on fav_mov_id = mov_id where fav_us_id=?";
	public static final String DELETE_FROM_FAVORITE = "delete from favorites where fav_us_id=? and  fav_mov_id=? limit 1";

	@Override
	public void addFavourites(long userId, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(ADD_MOVIES_TO_FAVORITE);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, moviesId);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Favourites getAllFavourites(long userId) throws FavouritesEmptyException {
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<Movies> moviesList = new ArrayList<Movies>();
		Favourites favorite = new Favourites();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementTwo = null;
		ResultSet resultSet = null;
		ResultSet resultSetTwo = null;
		Movies movies = null;
		try {
			preparedStatement = connection.prepareStatement(GET_MOVIES_FROM_FAVORITE);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				movies = new Movies();
				movies.setId(resultSet.getLong("mov_id"));
				movies.setTitle(resultSet.getString("mov_title"));
				movies.setGross(resultSet.getLong("mov_box_office"));
				movies.setActive(resultSet.getString("mov_active").equals("1"));
				movies.setDateOfLaunch(resultSet.getDate("mov_date_of_launch"));
				movies.setGenre(resultSet.getString("mov_genre"));
				movies.setHasTeaser(resultSet.getString("mov_has_teaser").equals("1"));
				moviesList.add(movies);
			}
			favorite.setMovieList(moviesList);
			preparedStatementTwo = connection.prepareStatement(GET_TOTAL_FAVORITE);
			preparedStatementTwo.setLong(1, userId);
			resultSetTwo = preparedStatementTwo.executeQuery();
			if (moviesList.size() == 0) {
				throw new FavouritesEmptyException();
			}
			while (resultSetTwo.next()) {
				favorite.setTotal(resultSetTwo.getInt("Total"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				preparedStatementTwo.close();
				resultSet.close();
				resultSetTwo.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return favorite;
	}

	@Override
	public void removeFavourites(long userID, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(DELETE_FROM_FAVORITE);
			preparedStatement.setLong(1, userID);
			preparedStatement.setLong(2, moviesId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}