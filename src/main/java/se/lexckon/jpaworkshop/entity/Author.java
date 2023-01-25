package se.lexckon.jpaworkshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false) // if you do not want to update the id
    private  int id;
    @Column(nullable = false, length = 80)
    private  String firstName;
    @Column(nullable = false, length = 80)
    private String lastName;
    @Column(nullable = false)
    @ManyToMany
    private List<Book> writtenBooks;
}
