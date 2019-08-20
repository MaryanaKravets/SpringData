package edu.spingdata.hw14.service;

import edu.spingdata.hw14.model.Author;
import edu.spingdata.hw14.model.Book;
import edu.spingdata.hw14.repository.AuthorRepository;
import edu.spingdata.hw14.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Service
public class PersonService implements IPersonService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public PersonService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Author addAuthor(Author author){
        return authorRepository.saveAndFlush(author);
    }

    @Override
    public void deleteAuthorById(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Book addBook(Book book){
       return bookRepository.saveAndFlush(book);
    }

    @Override
    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }

//    @Override
//    public List<Author> addBookToAuthor(int authorId, Book book) {
//       return entityManager.createQuery("select from Author as a where a.id=authorId",Author.class)
//                .getResultList();
//    }

    @Override
    public List<Book> sortedBookByAuthor(int authorId) {
        return bookRepository.findBooksByAuthorId(authorId);
    }

    @Override
    public List<Book> sortedBookByGenre(String genre) {
        return bookRepository.findBooksByGenre(genre);
    }

    @Override
    public Book updateBook(Book book){
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public Author updateAuthor(Author author){
        return authorRepository.saveAndFlush(author);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}