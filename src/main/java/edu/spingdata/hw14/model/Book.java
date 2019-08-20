package edu.spingdata.hw14.model;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
//@AllArgsConstructor
@Data
@Table(name = "books")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "author_id", nullable = false)
    private int authorId;

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "genre", nullable = false)
    private String genre;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "rate", nullable = false)
    private int rate;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "books")
    private Set<Author> authorSet=new HashSet<>();

    public Book(){};

//    public Book(int authorId, String title, String genre, String description, int rate){//, Set<Author> authorSet) {
//        this.authorId=authorId;
//        this.title = title;
//        this.genre = genre;
//        this.description = description;
//        this.rate = rate;
//      //  this.authorSet = authorSet;
//    }

    public void addAuthor(Author author){
        this.authorSet.add(author);
    }
}
