package se.lexckon.jpaworkshop.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    @ManyToMany(mappedBy = "authorSet")
    private Set<Book> writtenBooks;

    public Author() {
    }

    public Author(String firstName, String lastName) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(String firstName, String lastName, Set<Book> writtenBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.writtenBooks = writtenBooks;
    }

    public Author(int id, String firstName, String lastName, Set<Book> writtenBooks) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.writtenBooks = writtenBooks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getWrittenBooks() {
        if(writtenBooks == null) writtenBooks =new HashSet<>();
        return writtenBooks;
    }

    public void setWrittenBooks(Set<Book> writtenBooks) {
        this.writtenBooks = writtenBooks;
    }
    public  void addBook (Book book){
        if(book == null) throw  new IllegalArgumentException("the book data was null");
        if(writtenBooks == null)writtenBooks = new HashSet<>();
        writtenBooks.add(book);
        book.getAuthorSet().add(this);

    }
    public  void removeBook(Book book){
        if(book == null) throw new IllegalArgumentException("the book data was null");
        if(writtenBooks !=null){
            book.getAuthorSet().remove(this);
            writtenBooks.remove(book);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id && Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName) && Objects.equals(writtenBooks, author.writtenBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, writtenBooks);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", writtenBooks=" + writtenBooks +
                '}';
    }
}
