package io.taejung.tacademy.springboot.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.taejung.tacademy.springboot.domain.Book;
import io.taejung.tacademy.springboot.domain.BookRepositroy;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	private final BookRepositroy bookRepositroy;

	public BookServiceImpl(BookRepositroy bookRepositroy) {
		this.bookRepositroy = bookRepositroy;
	}

	@Override
	public Optional<Book> findById(Long id) {
		return bookRepositroy.findById(id);
	}

}
