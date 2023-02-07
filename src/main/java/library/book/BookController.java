package library.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	@Autowired
	private BookRepository repository;

	@GetMapping("/library")
	public List<BookBean> getBooks() {
		return repository.findAll();
	}
}
