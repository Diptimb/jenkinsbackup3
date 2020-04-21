package com.mindtree.movies.exceptions;

public class MovieNotFoundException extends DaoException{
	private static final long serialVersionUID=1L;
	public MovieNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public MovieNotFoundException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public MovieNotFoundException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
