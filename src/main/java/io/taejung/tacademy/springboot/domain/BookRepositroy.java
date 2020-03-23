package io.taejung.tacademy.springboot.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositroy extends JpaRepository<Book, Long> {
	
	List<Book> findByNameLike(String name);
	
}
