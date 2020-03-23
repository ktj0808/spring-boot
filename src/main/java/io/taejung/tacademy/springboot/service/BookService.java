package io.taejung.tacademy.springboot.service;

import java.util.Optional;

import io.taejung.tacademy.springboot.domain.Book;

public interface BookService {
	
	Optional<Book> findById(Long id);

}
