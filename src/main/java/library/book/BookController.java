package library.book;

import java.awt.print.Book;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	private BookRepository repository;

	@GetMapping("/books")
	public List<Book> getBooks() {
		return repository.findAll();
	}
}
