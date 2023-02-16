package com.librarypackage.library.dto;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.librarypackage.library.author.Author;
import com.librarypackage.library.book.BookBean;
import com.librarypackage.library.genre.Genre;

@Component
public class BookMapper {
	public BookBean toBook(BookCreationDto book, Genre genre, List<Author> author) {
		Random random = new Random();
		book.setNoOfCopies(random.nextInt(20) + 1);
		return new BookBean(generateISBN(), book.getName(),  book.getNoOfCopies(), genre, author);
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
