package se.lexckon.jpaworkshop.Dao;

import se.lexckon.jpaworkshop.entity.AppUser;
import se.lexckon.jpaworkshop.entity.Book;

import java.util.List;

public interface BookDao {
    Book findById(int id);
    List<Book> findAll();
    Book create(Book book);
    Book uppDate(Book book);
    void delete(int id);

}
