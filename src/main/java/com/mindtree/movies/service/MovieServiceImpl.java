package com.mindtree.movies.service;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.movies.dao.MovieDao;
import com.mindtree.movies.dao.MovieDaoImpl;
import com.mindtree.movies.entity.Movie;
import com.mindtree.movies.exceptions.DaoException;
import com.mindtree.movies.exceptions.ServiceException;

public class MovieServiceImpl implements MovieService {
	MovieDao m=new MovieDaoImpl();
	public List<Movie> triggMovieView(int id) throws ServiceException {
		List<Movie> movie =new ArrayList<Movie>();
		try{movie= m.getMovies(id);
		if(movie!=null)
			return movie;
		else
			return null;}
		catch(DaoException e) {
				throw new ServiceException(e.getLocalizedMessage(),e);
			
					}
	}
	public List<Movie> triggMovieBudget() throws ServiceException {
		List<Movie> movie =new ArrayList<Movie>();
		try{movie=m.getMoviesBudget();
		if(movie!=null)
			return movie;
		else
			return null;}
		catch(DaoException e) {
				throw new ServiceException(e.getLocalizedMessage(),e);
			
					}
	}
}
