package se.lexckon.jpaworkshop.Dao.Impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexckon.jpaworkshop.Dao.BookDao;
import se.lexckon.jpaworkshop.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Book findById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> findAll() {
        return entityManager.createQuery(
                "select b from Book b", Book.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Book create(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    @Transactional
    public Book uppDate(Book book) {
        return entityManager.merge(book);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Book.class, id));

    }
}
