package com.mindtree.movies.service;

import java.util.List;


import com.mindtree.movies.entity.Movie;
import com.mindtree.movies.exceptions.ServiceException;

public interface MovieService {

public List<Movie> triggMovieView(int id) throws ServiceException;
public List<Movie> triggMovieBudget() throws ServiceException;
}
