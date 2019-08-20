package edu.spingdata.hw14.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
//@AllArgsConstructor
@Data
@Table(name = "authors")
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name",nullable = false)
    private String fName;
    @Column(name = "last_name",nullable = false)
    private String lName;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   // @ManyToMany(cascade ={ CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "author_books",joinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")})
    private Set<Book> books= new HashSet<>();


//    public Author( String fName, String lName, Set<Book> books) {
//        this.fName = fName;
//        this.lName = lName;
//        this.books=books;
//       // for(Book book:books)book.setB
//    }

    public Author(){};

    public void addBook(Book book){
        this.books.add(book);
    }

}
