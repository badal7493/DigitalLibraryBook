package in.sp.main.entity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.entity.Book;
import in.sp.main.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	    @Autowired
	    private BookService bookService;

	    @GetMapping
	    public List<Book> getAllBooks() {
	        return bookService.getAllBooks();
	    }

	    @GetMapping("/{id}")
	    public Optional<Book> getBookById(@PathVariable int id) {
	        return bookService.getBookById(id);
	    }

	    @GetMapping("/search")
	    public Optional<Book> getBookByTitle(@RequestParam String title) {
	        return bookService.getBookByTitle(title);
	    }

	    @PostMapping
	    public Book addBook(@RequestBody Book book) {
	        return bookService.addBook(book);
	    }

	    @PutMapping("/{id}")
	    public Book updateBook(@PathVariable int id, @RequestBody Book bookDetails) {
	        return bookService.updateBook(id, bookDetails);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteBook(@PathVariable int id) {
	        bookService.deleteBook(id);
	    }

}
