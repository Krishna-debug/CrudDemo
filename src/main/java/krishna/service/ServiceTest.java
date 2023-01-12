package krishna.service;

import java.util.List;
import java.util.Optional;

import krishna.model.Books;

public interface ServiceTest {

	List<Books> getAllBooks();

	Optional<Books> getBookByID(Long bookId);

	Books saveRecords(Books book);

	Books updateRecords(Long bookId, Books book);

	boolean deleteRecords(Long bookId);

}
