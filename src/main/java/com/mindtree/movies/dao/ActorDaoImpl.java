package com.mindtree.movies.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.movies.entity.Actor;
import com.mindtree.movies.entity.Movie;
import com.mindtree.movies.exceptions.ActorNotFoundException;
import com.mindtree.movies.exceptions.DaoException;
import com.mindtree.movies.exceptions.UtilityException;
import com.mindtree.movies.utility.JdbcConnection;

public class ActorDaoImpl implements ActorDao {
	public List<Movie> getActor(int id) throws DaoException{
		List<Movie> movie=new ArrayList<Movie>();
		try {
			Connection con = JdbcConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs1 = st.executeQuery(
					"   select t.movie_id,movie_name,actor.actor_id,actor_name from actor inner join( select movie.movie_id,movie_name,actor_id from movie inner join moviecast on movie.movie_id=moviecast.movie_id) as t on t.actor_id=actor.actor_id where actor.actor_id='"+id+"'");
			while (rs1.next()) {
				Movie mov=new Movie();
				mov.setMovie_id(rs1.getInt("movie_id"));
				mov.setMovie_name(rs1.getString("movie_name"));
				Actor ac=new Actor();
				ac.setActor_id(rs1.getInt("actor_id"));
				ac.setActor_name(rs1.getString("actor_name"));
				mov.setActor(ac);
				movie.add(mov);}
			for(Movie m:movie) {
				if(m.getActor().getActor_id()==id) {
					st.close();
				con.close();
				return movie;}}
			try {
				throw new ActorNotFoundException("Actors not found");}
			catch(ActorNotFoundException e2) {
				throw new DaoException(e2.getLocalizedMessage(),e2);
			}
			
		}catch (SQLException e) {
			System.out.println(e);
			throw new DaoException("Error in fetching data");
		}catch(UtilityException e1) {
			throw new DaoException(e1.getLocalizedMessage(),e1);
		}
	}
	public List<Actor> getActorCount() throws DaoException{
		List<Actor> actor=new ArrayList<Actor>();
		try {
			Connection con = JdbcConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs1 = st.executeQuery(
					"select count(moviecast.movie_id) as count, actor_name,actor.actor_id  from actor inner join moviecast on actor.actor_id=moviecast.actor_id group by actor.actor_id having count=1");
			
			while (rs1.next()) {
			Actor act=new Actor();
			act.setActor_id(rs1.getInt("actor_id"));
			act.setActor_name(rs1.getString("actor_name"));
			act.setCount(rs1.getInt("count"));
			actor.add(act);}
			if(actor!=null) {
					st.close();
				con.close();
				return actor;}
			try {
				throw new ActorNotFoundException("No actors");}
			catch(ActorNotFoundException e2) {
				throw new DaoException(e2.getLocalizedMessage(),e2);
			}
			
		}catch (SQLException e) {
			System.out.println(e);
			throw new DaoException("Error in fetching data");
		}catch(UtilityException e1) {
			throw new DaoException(e1.getLocalizedMessage(),e1);
		}
	}
	public List<Actor> getActorSort() throws DaoException{
		List<Actor> actor=new ArrayList<Actor>();
		try {
			Connection con = JdbcConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs1 = st.executeQuery(
					"   select*from actor order by amount asc;");
			
			while (rs1.next()) {
			Actor act=new Actor();
			act.setActor_id(rs1.getInt("actor_id"));
			act.setActor_name(rs1.getString("actor_name"));
			act.setRenum(rs1.getDouble("amount"));
			actor.add(act);}
			if(actor!=null) {
					st.close();
				con.close();
				return actor;}
			try {
				throw new ActorNotFoundException("No actors");}
			catch(ActorNotFoundException e2) {
				throw new DaoException(e2.getLocalizedMessage(),e2);
			}
			
		}catch (SQLException e) {
			//System.out.println(e);
			throw new DaoException(e.getLocalizedMessage(),e);
		}catch(UtilityException e1) {
			throw new DaoException(e1.getLocalizedMessage(),e1);
		}
	}
}
