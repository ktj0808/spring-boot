package io.taejung.tacademy.springboot.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	BookRepositroy repositroy;
	
	@Test
	public void testSave() {
		Book book = new Book();
		book.setName("boot-spring-boot");
		book.setIsbn10("0123456789");
		book.setIsbn13("0123456789012");
		
		assertThat(book.isNew()).isTrue();
		
		repositroy.save(book);
		
		assertThat(book.isNew()).isFalse();
	}
	
	@Test
	public void testFindByNameLike() {
		Book book = new Book();
		book.setName("boot-spring-boot");
		book.setIsbn10("0123456789");
		book.setIsbn13("0123456789012");

		repositroy.save(book);
		
		List<Book> books = repositroy.findByNameLike("boot%");
		assertThat(books).isNotEmpty();
		
		books = repositroy.findByNameLike("book");
		assertThat(books).isEmpty();
	}
}
