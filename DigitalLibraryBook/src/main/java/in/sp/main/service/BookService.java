package in.sp.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entity.Book;
import in.sp.main.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public Book addBook(Book book)
	{
		 return bookRepository.save(book);
	}

	public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
	
    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }
    
    public Optional<Book> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
    
    public Book updateBook(int id, Book bookDetails) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setGenre(bookDetails.getGenre());
            book.setAvailability(bookDetails.getAvailability());
            return bookRepository.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found"));
    }
    
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
	

}
