package se.lexckon.jpaworkshop.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false) // if you do not want to update the id
    private int id;
    @Column(nullable = false,length = 100)
    private  String isbn;
    @Column(nullable = false, length = 80)
    private  String title;
    @Column(nullable = false)
    private  int maxLoanDays;
    @OneToMany(mappedBy = "bookLoan",orphanRemoval = true)
    private List<BookLoan> listOfBook;

    @ManyToMany
    private Set<Author> authorSet;
    public Book() {
    }

    public Book(String isbn, String title, int maxLoanDays) {
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }


    public Book(int id, String isbn, String title, int maxLoanDays) {
        this();
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxLoanDays() {
        return maxLoanDays;
    }

    public void setMaxLoanDays(int maxLoanDays) {
        this.maxLoanDays = maxLoanDays;
    }

    public List<BookLoan> getListOfBook() {
        if(listOfBook == null) listOfBook = new ArrayList<>();
        return listOfBook;
    }

    public void setListOfBook(List<BookLoan> listOfBook) {
        this.listOfBook = listOfBook;
    }

    public Set<Author> getAuthorSet() {
        if(authorSet ==null) authorSet= new HashSet<>();
        return authorSet;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }
    public void addAuthor(Author author){
        if(author == null)throw new IllegalArgumentException("the author data was null");
        if(authorSet==null)authorSet= new HashSet<>();
        authorSet.add(author);
        author.getWrittenBooks().add(this);
    }


    public void removeAuthor(Author author){
        if(author == null) throw new IllegalArgumentException("Th author data was null");
        if(authorSet !=null)
        author.getWrittenBooks().remove(this);
        authorSet.remove(author);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && maxLoanDays == book.maxLoanDays && Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, title, maxLoanDays);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", maxLoanDays=" + maxLoanDays +
                '}';
    }
}
