package com.mindtree.movies.dao;

import java.util.List;
import com.mindtree.movies.entity.Movie;
import com.mindtree.movies.exceptions.DaoException;

public interface MovieDao {
	public List<Movie> getMovies(int id) throws DaoException;
	public List<Movie> getMoviesBudget() throws DaoException;
}
