package com.mindtree.movies.service;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.movies.dao.ActorDao;
import com.mindtree.movies.dao.ActorDaoImpl;
import com.mindtree.movies.entity.Actor;
import com.mindtree.movies.entity.Movie;
import com.mindtree.movies.exceptions.DaoException;
import com.mindtree.movies.exceptions.ServiceException;

public class ActorServiceImpl implements ActorService{
	ActorDao m=new ActorDaoImpl();
	public List<Movie> triggMovieView(int id) throws ServiceException {
		List<Movie> movie =new ArrayList<Movie>();
		try{movie=m.getActor(id);
		if(movie!=null)
			return movie;
		else
			return null;}
		catch(DaoException e) {
				throw new ServiceException(e.getLocalizedMessage(),e);
			
					}
	}
	public List<Actor> triggActorCount() throws ServiceException {
		List<Actor> actor =new ArrayList<Actor>();
		try{actor=m.getActorCount();
		//System.out.println(actor.size());
		if(actor!=null)
			return actor;
		else
			return null;}
		catch(DaoException e) {
				throw new ServiceException(e.getLocalizedMessage(),e);
			
					}
	}
	public List<Actor> triggActorSort() throws ServiceException {
		List<Actor> actor =new ArrayList<Actor>();
		try{actor=m.getActorSort();
		//System.out.println(actor.size());
		if(actor!=null)
			return actor;
		else
			return null;}
		catch(DaoException e) {
				throw new ServiceException(e.getLocalizedMessage(),e);
			
					}
	}
}
