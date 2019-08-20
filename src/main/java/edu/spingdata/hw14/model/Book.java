package edu.spingdata.hw14.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
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
@JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "books")
    private Set<Author> authorSet=new HashSet<>();

    public Book(){};

}
