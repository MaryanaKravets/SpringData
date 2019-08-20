package edu.spingdata.hw14.service;

import edu.spingdata.hw14.exception.NotFoundExceptions;
import edu.spingdata.hw14.model.Author;
import edu.spingdata.hw14.model.Book;
import edu.spingdata.hw14.repository.AuthorRepository;
import edu.spingdata.hw14.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import java.util.stream.Collectors;

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

//    private List<Book> bookList = new ArrayList<>(Arrays.asList(
//            new Book(1, "Wilder girls", "Thriller",
//                    "It's been eighteen months since the Raxter School for Girls was put under quarantine", 5),
//            new Book(2, "Java Core", "Science",
//                    "In this book you will find lots of sample code to fully understand the Java language and library", 4),
//            new Book(3, "ProGit", "Science",
//                    "This book to cover Version Control System and Git", 3),
//            new Book(4, "Spring in action", "Science",
//                    "Фреймворк Spring Framework - необходимий инструмент для разработчиков приложений на Java", 4),
//            new Book(5, " Під куполом", "Fantasy",
//                    "Напередодні Гелловіна місто Честер Мілл невідома сила накриває прозорим куполом", 3),
//            new Book(6, " The chain", "Thriller",
//                    "A stranger has kidnapped your child", 4),
//            new Book(7, " Spin the dawn", "Fantasy",
//                    "About young girl who poses as a boy to compete for the role of imperial tailor", 1),
//            new Book(8, " The marriage clock", "Comedy",
//                    "In Zara Raheem's fresh,funny,smart debut,a young, Muslim-American woman is given three months to find the husband", 5),
//            new Book(9, " The billion dollar secret", "Business",
//                    "There is no other book available anywhere in the world that contains this much entrepreneurial experience", 3)
//    ));
//    private List<Author> authorList = new ArrayList<>(Arrays.asList(
//            new Author(1, "Rory", "Power",
//                    new HashSet<Book>(bookList.subList(0, 1))),
//            new Author(2, "Say", "Horstmann",
//                    new HashSet<Book>(bookList.subList(1, 2))),
//            new Author(3, "Scott", "Chacon",
//                    new HashSet<Book>(bookList.subList(2, 3))),
//            new Author(4, "Crag", "Walls",
//                    new HashSet<Book>(bookList.subList(3, 4))),
//            new Author(5, "Стівен", "Кінг",
//                    new HashSet<Book>(bookList.subList(4, 5))),
//            new Author(6, "Adrian", "McKinty",
//                    new HashSet<Book>(bookList.subList(5, 6))),
//            new Author(7, "Elizabeth", "Lim",
//                    new HashSet<Book>(bookList.subList(6, 7))),
//            new Author(8, "Zara", "Raheem",
//                    new HashSet<Book>(bookList.subList(7, 8))),
//            new Author(9, "Rafael", "Badziag",
//                    new HashSet<Book>(bookList.subList(8, 9)))
//    ));

    @Override
    public Author addAuthor(Author author){//int id, String fName, String lName) {
        Author author1= authorRepository.saveAndFlush(author);
        return author1;
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

    @Override
    public List<Author> addBookToAuthor(int authorId, Book book) {
       return entityManager.createQuery("select from Author as a where a.id=authorId",Author.class)
                .getResultList();
    }

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
                 //updateAuthor(authorId,updateAuthorId);
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