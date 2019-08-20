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


//    @ResponseBody
//    @PutMapping("/author/book")
//    public Map<Integer, Book> addBookToAuthor(
//            @RequestParam(value = "authorId") int authorId,
//            @RequestParam(value = "bookId") int bookId,
//            @RequestParam(value = "bookTitle") String bookTitle,
//            @RequestParam(value = "bookGenre") String bookGenre,
//            @RequestParam(value = "bookDesc") String bookDesc,
//            @RequestParam(value = "bookRate") int bookRate
//    ) {
//        Map<Integer, Book> map = new LinkedHashMap<>();
//        Book book1 = new Book(bookId, bookTitle, bookGenre, bookDesc, bookRate);
//        personService.addBookToAuthor(authorId, book1);
//        map.put(authorId, book1);
//        return map;
//    }

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
    public void updateAuthor(@RequestBody Author author){
            //@RequestParam("id") int updateId, @PathVariable("id") int id) {
         iPersonService.updateAuthor(author);//id, updateId);
    }

    @ResponseBody
    @PatchMapping("book/{id}")
    public void updateBook(@RequestBody Book book){
            //@RequestParam("id") int updateId, @PathVariable("id") int id) {
        iPersonService.updateBook(book);//id, updateId);
    }
}


