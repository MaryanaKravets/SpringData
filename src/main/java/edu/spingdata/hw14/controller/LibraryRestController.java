package edu.spingdata.hw14.controller;

import edu.spingdata.hw14.model.Author;
import edu.spingdata.hw14.model.Book;
import edu.spingdata.hw14.service.IPersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@AllArgsConstructor
@RestController
public class LibraryRestController {

    IPersonService iPersonService;


    @ResponseBody
    @GetMapping("/book")
    public List<Book> findAllBook() {

        return iPersonService.findAllBooks();
    }

    @ResponseBody
    @GetMapping("/author")
    public List<Author> findAllAuthor() {

        return iPersonService.findAllAuthors();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public List<Book> sortedBookByAuthor(@PathVariable("id") int id) {

        return iPersonService.sortedBookByAuthor(id);
    }

    @ResponseBody
    @GetMapping("")
    public List<Book> sortedBookByGenre(@RequestParam(value = "genre") String genre) {
        return iPersonService.sortedBookByGenre(genre);
    }

    @ResponseBody
    @PostMapping("/author")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        iPersonService.addAuthor(author);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @ResponseBody
    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        iPersonService.addBook(book);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @ResponseBody
    @DeleteMapping("/author/{id}")
    public void deleteAuthor(@PathVariable("id") int authorId) {
        iPersonService.deleteAuthorById(authorId);
    }

    @ResponseBody
    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable("id") int bookId) {
        iPersonService.deleteBookById(bookId);
    }

    @ResponseBody
    @PatchMapping("author/{id}")
    public Author updateAuthor(@RequestBody Author author) {
        return iPersonService.updateAuthor(author);
    }

    @ResponseBody
    @PatchMapping("book/{id}")
    public Book updateBook(@RequestBody Book book) {
        return iPersonService.updateBook(book);
    }
}


