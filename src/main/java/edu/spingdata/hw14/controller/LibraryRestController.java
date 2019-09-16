package edu.spingdata.hw14.controller;

import edu.spingdata.hw14.model.Author;
import edu.spingdata.hw14.model.Book;
import edu.spingdata.hw14.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class LibraryRestController {

    private final PersonService personService;

    @ResponseBody
    @GetMapping("/book")
    public List<Book> findAllBook() {

        return personService.findAllBooks();
    }

    @ResponseBody
    @GetMapping("/author")
    public List<Author> findAllAuthor() {

        return personService.findAllAuthors();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public List<Book> sortedBookByAuthor(@PathVariable("id") int id) {

        return personService.sortedBookByAuthor(id);
    }

    @ResponseBody
    @GetMapping
    public List<Book> sortedBookByGenre(@RequestParam(value = "genre") String genre) {

        return personService.sortedBookByGenre(genre);
    }

    @ResponseBody
    @PostMapping("/author")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        personService.addAuthor(author);

        return ResponseEntity

                .status(HttpStatus.CREATED)
                .build();
    }

    @ResponseBody
    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        personService.addBook(book);

        return ResponseEntity

                .status(HttpStatus.CREATED)
                .build();
    }

    @ResponseBody
    @DeleteMapping("/author/{id}")
    public void deleteAuthor(@PathVariable("id") int authorId) {

        personService.deleteAuthorById(authorId);
    }

    @ResponseBody
    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable("id") int bookId){

        personService.deleteBookById(bookId);
    }

    @ResponseBody
    @PatchMapping("author/{id}")
    public Author updateAuthor(@RequestBody Author author) {

        return personService.updateAuthor(author);
    }

    @ResponseBody
    @PatchMapping("book/{id}")
    public Book updateBook(@RequestBody Book book) {

        return personService.updateBook(book);
    }
}


