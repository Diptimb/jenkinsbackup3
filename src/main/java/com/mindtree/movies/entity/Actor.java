package com.mindtree.movies.entity;

public class Actor {
private int actor_id;
private String actor_name;
private double renum;
private int count;
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public int getActor_id() {
	return actor_id;
}


public Actor() {
	super();
}
public String toString1() {
	return "Actor [actor_id=" + actor_id + ", actor_name=" + actor_name + ", count=" + count + "]";
}
@Override
public String toString() {
	return "Actor [actor_id=" + actor_id + ", actor_name=" + actor_name + ", renum=" + renum + "]";
}
public void setActor_id(int actor_id) {
	this.actor_id = actor_id;
}
public String getActor_name() {
	return actor_name;
}
public void setActor_name(String actor_name) {
	this.actor_name = actor_name;
}
public double getRenum() {
	return renum;
}
public void setRenum(double renum) {
	this.renum = renum;
}

}
