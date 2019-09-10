package edu.spingdata.hw14.repository;

import edu.spingdata.hw14.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
