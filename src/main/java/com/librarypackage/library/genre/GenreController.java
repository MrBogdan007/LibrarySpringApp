package com.librarypackage.library.genre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {
	@Autowired
	private GenreRepository repository;

	@GetMapping("/genre")
	public List<Genre> getAllGenres() {
		return repository.findAll();
	}

	@PostMapping("/genre")
	@PreAuthorize("hasRole('ADMIN')")
	public Genre postAllGenres(@RequestBody Genre genre) {
		return repository.save(genre);
	}
}
