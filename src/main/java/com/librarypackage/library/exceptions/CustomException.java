package com.librarypackage.library.exceptions;

import org.springframework.dao.EmptyResultDataAccessException;

public class CustomException extends Exception {
	public CustomException(String msg, EmptyResultDataAccessException e) {
		super(msg, e);
	}
}
