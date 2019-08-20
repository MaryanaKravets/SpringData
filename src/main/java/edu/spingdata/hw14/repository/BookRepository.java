package edu.spingdata.hw14.repository;

import edu.spingdata.hw14.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

     List<Book> findBooksByGenre(String genre);

     List<Book> findBooksByAuthorId(int id);

//     @Transactional
//     @Modifying//(clearAutomatically = true)
//     @Query("update Book b set b.id=:updateBookId where b.id=:bookId")
//     void updateBook(int bookId, @Param("updateBookId") int updateBookId);

}
