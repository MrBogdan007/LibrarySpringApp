package com.librarypackage.library.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class CodeExpection extends Exception {
	public CodeExpection(String msg) {
		super(msg);
	}
}
