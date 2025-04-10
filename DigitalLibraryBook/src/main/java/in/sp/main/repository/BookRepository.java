package in.sp.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sp.main.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	Optional<Book> findByTitle(String title);

}
