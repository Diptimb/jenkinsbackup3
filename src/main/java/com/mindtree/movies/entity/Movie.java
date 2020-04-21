package com.mindtree.movies.entity;

import java.io.Serializable;

public class Movie implements Serializable{
private int movie_id;
private String movie_name;
private double budget;
private Actor actor;

public Movie() {
	super();
}
public int getMovie_id() {
	return movie_id;
}
@Override
public String toString() {
	return "Movie [movie_id=" + movie_id + ", movie_name=" + movie_name + ", budget=" + budget + ", actor=" + actor.toString()
			+ "]";
}
public String toString1() {
	return "Movie [movie_id=" + movie_id + ", movie_name=" + movie_name + ", budget=" + budget 
			+ "]";
}
public void setMovie_id(int movie_id) {
	this.movie_id = movie_id;
}
public String getMovie_name() {
	return movie_name;
}
public void setMovie_name(String movie_name) {
	this.movie_name = movie_name;
}
public double getBudget() {
	return budget;
}
public void setBudget(double budget) {
	this.budget = budget;
}
public Actor getActor() {
	return actor;
}
public void setActor(Actor actor) {
	this.actor = actor;
}
}
