package com.librarypackage.library.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorContoller {

@Autowired
private AuthorRepository repository;

	@GetMapping("/author")
	public void getAuthor() {
		repository.findAll();
	}

	@PostMapping("/author")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Author> createAuthor(@RequestBody List<Author> author) {
		return repository.saveAll(author);
	}
}
