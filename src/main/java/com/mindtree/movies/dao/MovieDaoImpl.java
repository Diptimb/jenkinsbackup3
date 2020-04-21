package com.mindtree.movies.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mindtree.movies.exceptions.*;
import com.mindtree.movies.entity.Actor;
import com.mindtree.movies.entity.Movie;
import com.mindtree.movies.utility.JdbcConnection;

public class MovieDaoImpl implements MovieDao {
	public List<Movie> getMovies(int id) throws DaoException {
		List<Movie> movie = new ArrayList<Movie>();
		try {
			Connection con = JdbcConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs1 = st.executeQuery(
					" select movie.movie_id,movie_name,actor_id,actor_name from movie inner join (select actor.actor_id,movie_id,actor_name from moviecast inner join actor on moviecast.actor_id=actor.actor_id)as t on t.movie_id=movie.movie_id where movie.movie_id='"
							+ id + "'");

			while (rs1.next()) {
				Movie mov = new Movie();
				mov.setMovie_id(rs1.getInt("movie_id"));
				mov.setMovie_name(rs1.getString("movie_name"));
				Actor ac = new Actor();
				ac.setActor_id(rs1.getInt("actor_id"));
				ac.setActor_name(rs1.getString("actor_name"));
				mov.setActor(ac);
				movie.add(mov);
			}
			for (Movie m : movie) {
				if (m.getMovie_id() == id) {
					st.close();
					con.close();
					return movie;
				}
			}
			try {
				throw new MovieNotFoundException("Movie not in database");
			} catch (MovieNotFoundException e2) {
				throw new DaoException(e2.getLocalizedMessage(), e2);
			}

		} catch (SQLException e) {
			System.out.println(e);
			throw new DaoException(e.getLocalizedMessage(), e);
		} catch (UtilityException e1) {
			throw new DaoException(e1.getLocalizedMessage(), e1);
		}
	}

	public List<Movie> getMoviesBudget() throws DaoException {
		List<Movie> movie = new ArrayList<Movie>();
		try {
			Connection con = JdbcConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs1 = st.executeQuery("  select*from movie where budget>100000");
			while (rs1.next()) {
				Movie mov = new Movie();
				mov.setMovie_id(rs1.getInt("movie_id"));
				mov.setMovie_name(rs1.getString("movie_name"));
				mov.setBudget(rs1.getDouble("budget"));
				movie.add(mov);
			}
			if (movie != null) {
				st.close();
				con.close();
				return movie;
			}

			try {
				throw new MovieNotFoundException("Movies not in database");
			} catch (MovieNotFoundException e2) {
				throw new DaoException(e2.getLocalizedMessage(), e2);
			}

		} catch (SQLException e) {
			System.out.println(e);
			throw new DaoException(e.getLocalizedMessage(), e);
		} catch (UtilityException e1) {
			throw new DaoException(e1.getLocalizedMessage(), e1);
		}
	}
}
