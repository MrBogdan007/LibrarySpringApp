package com.librarypackage.library.book;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.librarypackage.library.dto.BookCreationDto;
import com.librarypackage.library.dto.BookMapper;
import com.librarypackage.library.genre.Genre;
import com.librarypackage.library.genre.GenreRepository;

@RestController
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private GenreRepository genreRepository;
	@Autowired
	private BookMapper mapper;

	@GetMapping("/books")
	public List<BookBean> getBooks() {

		return repository.findAll();
	}

	@PostMapping("/books")
	public void postBooks(@RequestBody BookCreationDto bookDTO) {
		UUID genre_id = bookDTO.getGenre_id();
		String myString = bookDTO.getSome();
		Genre genre = genreRepository.findById(genre_id).orElse(null);
		BookBean newBook = mapper.toBook(bookDTO, genre);
		repository.save(newBook);
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

	@Override
	public String toString() {
		return null;

	}

	private static String toString(BigInteger b) {
		return b.toString();
	}
}
