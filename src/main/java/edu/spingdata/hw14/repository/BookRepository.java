package edu.spingdata.hw14.repository;

import edu.spingdata.hw14.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findBooksByGenre(String genre);

    List<Book> findBooksByAuthorId(int id);
}
