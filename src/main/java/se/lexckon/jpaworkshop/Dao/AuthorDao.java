package se.lexckon.jpaworkshop.Dao;

import se.lexckon.jpaworkshop.entity.AppUser;
import se.lexckon.jpaworkshop.entity.Author;

import java.util.List;

public interface AuthorDao {
    Author findById(int id);
    List<Author> findAll();
    Author create(Author author);
    Author uppDate(Author author);
    void delete(int id);

}
