package com.librarypackage.library.exceptions;

import org.springframework.dao.DataAccessException;

public class DataAccessExceptionClass extends Exception {
	public DataAccessExceptionClass(String msg, DataAccessException e) {
		super(msg, e);
	}
}
