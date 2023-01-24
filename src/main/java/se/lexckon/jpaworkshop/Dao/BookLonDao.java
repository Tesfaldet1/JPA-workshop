package se.lexckon.jpaworkshop.Dao;

import se.lexckon.jpaworkshop.entity.Book;
import se.lexckon.jpaworkshop.entity.BookLoan;

import java.util.List;

public interface BookLonDao {
    BookLoan findById(int id);
    List<BookLoan> findAll();
    BookLoan create(BookLoan bookLoan);
    BookLoan uppDate(BookLoan bookLoan);
    void delete(int id);

}
