package com.librarypackage.library.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	@Autowired
	private BookRepository repository;

	@GetMapping("/books")
	public List<BookBean> getBooks() {

		return repository.findAll();
	}

	@PostMapping("/books")
	public void postBooks(@RequestBody BookBean book) {

		repository.save(book);
	}
}
