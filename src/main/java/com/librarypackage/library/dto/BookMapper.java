package com.librarypackage.library.dto;

import java.math.BigInteger;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.librarypackage.library.book.BookBean;
import com.librarypackage.library.genre.Genre;

@Component
public class BookMapper {
	public BookBean toBook(BookCreationDto book, Genre genre) {
		return new BookBean(generateISBN(), book.getName(), genre);
	}

	private static String generateISBN() {
		BigInteger b = new BigInteger(34, new Random());
		String s = toString(b);
		String[] arrOfStr = s.split("");
		arrOfStr[2] += "-";
		arrOfStr[4] += "-";
		arrOfStr[7] += "-";
		String ISBN = String.join("", arrOfStr);
		return "978-" + ISBN;
	}

	private static String toString(BigInteger b) {
		return b.toString();
	}
}
