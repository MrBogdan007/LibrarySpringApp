package com.librarypackage.library.book;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.librarypackage.library.author.Author;
import com.librarypackage.library.author.AuthorRepository;
import com.librarypackage.library.dto.BookCreationDto;
import com.librarypackage.library.dto.BookMapper;
import com.librarypackage.library.exceptions.CodeExpection;
import com.librarypackage.library.exceptions.CustomException;
import com.librarypackage.library.exceptions.DataAccessExceptionClass;
import com.librarypackage.library.genre.Genre;
import com.librarypackage.library.genre.GenreRepository;

@RestController
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private GenreRepository genreRepository;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookMapper mapper;
	private static final Logger log = LoggerFactory.getLogger(BookController.class);



	@GetMapping("/books")
	public List<BookBean> getBooks() throws CodeExpection {

		try {
			return repository.findAll();
		} catch (Exception ex) {
			throw new CodeExpection("The library is empty");
		}
	}


	@PostMapping("/books")
	@PreAuthorize("hasRole('ADMIN')")
	public void postBooks(@RequestBody BookCreationDto bookDTO) {
		UUID genre_id = bookDTO.getGenre_id();
		UUID author_id = bookDTO.getAuthor_id();
		Genre genre = genreRepository.findById(genre_id).orElse(null);
		Author author = authorRepository.findById(genre_id).orElse(null);
		BookBean newBook = mapper.toBook(bookDTO, genre, author);
		repository.save(newBook);
	}

	@PutMapping("/books/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void updateBook(@RequestBody BookBean book, @PathVariable String id) {
		repository.save(book);
	}

	@DeleteMapping("/books/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Object> deleteBook(@PathVariable String id) throws DataAccessExceptionClass, CustomException {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();

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
