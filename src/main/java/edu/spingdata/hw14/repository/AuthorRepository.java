package edu.spingdata.hw14.repository;

import edu.spingdata.hw14.model.Author;
import edu.spingdata.hw14.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {


//    @Transactional
//    @Modifying//(clearAutomatically = true)
//    @Query("update Author a set a.id=?2 where a.id=?1")
//    void updateAuthor(int authorId, int updateAuthorId);

}
