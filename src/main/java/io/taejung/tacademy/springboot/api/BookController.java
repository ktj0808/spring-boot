package io.taejung.tacademy.springboot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.taejung.tacademy.springboot.domain.Book;
import io.taejung.tacademy.springboot.service.BookService;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/{bookId}")
	public ResponseEntity<Book> findById(@PathVariable Long bookId){
		Book book = bookService.findById(bookId)
				.orElseThrow(() -> new RuntimeException("Not found: " + bookId));
		return ResponseEntity.ok(book);
		
	}
}	
