package com.mindtree.movies.dao;

import java.util.List;

import com.mindtree.movies.entity.Actor;
import com.mindtree.movies.entity.Movie;
import com.mindtree.movies.exceptions.DaoException;

public interface ActorDao {
	public List<Movie> getActor(int id) throws DaoException;
	public List<Actor> getActorCount() throws DaoException;
	public List<Actor> getActorSort() throws DaoException;
	
}
