package com.mindtree.movies.service;

import java.util.List;

import com.mindtree.movies.entity.Actor;
import com.mindtree.movies.entity.Movie;
import com.mindtree.movies.exceptions.ServiceException;

public interface ActorService {
	public List<Movie> triggMovieView(int id) throws ServiceException;
	public List<Actor> triggActorCount() throws ServiceException;
	public List<Actor> triggActorSort() throws ServiceException;
}
