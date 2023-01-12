package krishna.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import krishna.model.Books;
import krishna.repo.BookRepo;
import krishna.service.ServiceTest;

@Service
public class ServiceImplements implements ServiceTest {

	@Autowired
	BookRepo bookRepo;

	public List<Books> getAllBooks() {
		return bookRepo.findAllByDeletedFalse();
	}

	public Optional<Books> getBookByID(Long bookId) {
		Books b = bookRepo.findById(bookId).get();
		if (b.isDeleted())
			return null;
		// return Optional.empty();

		return bookRepo.findById(bookId);
	}

	public Books saveRecords(Books book) {
		return bookRepo.save(book);
	}

	public Books updateRecords(Long bookId, Books book) {
		Books b = bookRepo.getById(bookId);
		b.setbName(book.getbName());
		b.setPrice(book.getPrice());

		return bookRepo.save(b);

	}

	public boolean deleteRecords(Long bookId) {
		Books b = bookRepo.findById(bookId).get();
		if (!b.isDeleted()) {
			b.setDeleted(true);
			bookRepo.save(b);
			return true;
		}

		return false;
	}

}
