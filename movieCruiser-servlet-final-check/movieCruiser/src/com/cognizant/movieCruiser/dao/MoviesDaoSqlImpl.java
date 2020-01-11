package com.cognizant.movieCruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cognizant.movieCruiser.model.Movies;
import com.cognizant.movieCruiser.util.DateUtil;

public class MoviesDaoSqlImpl implements MoviesDao {
	public static final String GET_ALL_MOVIES_LIST_ADMIN = "select * from movies";
	public static final String GET_ALL_MOVIES_LIST_CUSTOMER = "select * from movies where mov_active = 1 and mov_date_of_launch > (select CURDATE())";
	public static final String MODIFY_MOVIE_LIST = "update movies set mov_title = ?, mov_box_office = ?, mov_active = ?, mov_date_of_launch = ?, mov_genre = ?, mov_has_teaser = ? where mov_id = ?";
	public static final String SELECT_MOVIE = "select * from movies where mov_id = ?";

	@Override
	public List<Movies> getMovieListAdmin() {
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<Movies> moviesList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_MOVIES_LIST_ADMIN);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mov_id"));
				movies.setTitle(resultSet.getString("mov_title"));
				movies.setGross(resultSet.getLong("mov_box_office"));
				movies.setActive(resultSet.getString("mov_active").equals("1"));
				movies.setDateOfLaunch(resultSet.getDate("mov_date_of_launch"));
				movies.setGenre(resultSet.getString("mov_genre"));
				movies.setHasTeaser(resultSet.getString("mov_has_teaser").equals("1"));
				moviesList.add(movies);
			}
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return moviesList;
	}

	@Override
	public List<Movies> getMovieListCustomer() {
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<Movies> moviesList = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_MOVIES_LIST_CUSTOMER);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mov_id"));
				movies.setTitle(resultSet.getString("mov_title"));
				movies.setGross(resultSet.getLong("mov_box_office"));
				movies.setActive(resultSet.getString("mov_active").equals("1"));
				movies.setDateOfLaunch(resultSet.getDate("mov_date_of_launch"));
				movies.setGenre(resultSet.getString("mov_genre"));
				movies.setHasTeaser(resultSet.getString("mov_has_teaser").equals("1"));
				moviesList.add(movies);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return moviesList;
	}

	@Override
	public void modifyMovie(Movies movies) {
		Connection connection = ConnectionHandler.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(MODIFY_MOVIE_LIST);
			preparedStatement.setString(1, movies.getTitle());
			preparedStatement.setFloat(2, movies.getGross());
			preparedStatement.setBoolean(3, movies.getActive());
			preparedStatement.setDate(4, DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
			preparedStatement.setString(5, movies.getGenre());
			preparedStatement.setBoolean(6, movies.getHasTeaser());
			preparedStatement.setLong(7, movies.getId());
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Movies getMovie(Long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Movies movies = null;
		try {
			preparedStatement = connection.prepareStatement(SELECT_MOVIE);
			preparedStatement.setLong(1, moviesId);
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
			}
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
		return movies;
	}
}
