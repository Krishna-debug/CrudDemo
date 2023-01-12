package krishna.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import krishna.model.Books;
import krishna.service.ServiceTest;

@RestController
public class MyController {

	@Autowired
	ServiceTest bookService;

	@GetMapping("/books")
	public List<Books> getAll() {
		return bookService.getAllBooks();
	}

	@GetMapping("/books/{id}")
	public Optional<Books> getByID(@PathVariable("id") Long bookId) {
		return bookService.getBookByID(bookId);
	}

	@PostMapping("/insert")
	public Books saveData(@RequestBody Books book) {
		return bookService.saveRecords(book);

	}

	@PutMapping("/update/{id}")
	public Books updateValue(@PathVariable("id") Long bookId, @RequestBody Books book) {
		return bookService.updateRecords(bookId, book);
	}

	@DeleteMapping("/books/{id}")
	public String deleteData(@PathVariable("id") Long bookId) {
		if (bookService.deleteRecords(bookId))
			return "Deleted Sucessfully";

		return "Record Not Present";
	}

}
