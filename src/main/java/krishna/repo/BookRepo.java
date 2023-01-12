package krishna.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import krishna.model.Books;

@Repository
public interface BookRepo extends JpaRepository<Books, Long> {

	List<Books> findAllByDeletedFalse();

}
