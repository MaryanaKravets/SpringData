package edu.spingdata.hw14.service;

import edu.spingdata.hw14.model.Author;
import edu.spingdata.hw14.model.Book;

import java.util.List;

public interface IPersonService {

    Author addAuthor(Author author);

    void deleteAuthorById (int id);

    Book addBook(Book book);

    void deleteBookById(int id);

//    List<Author> addBookToAuthor(int authorId, Book book);

    List<Book> sortedBookByAuthor(int authorId);

    List<Book> sortedBookByGenre(String genre);

    Book updateBook(Book book);

    Author updateAuthor(Author author);

    List<Author> findAllAuthors();

    List<Book> findAllBooks();
}
