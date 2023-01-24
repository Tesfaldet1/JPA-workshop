package se.lexckon.jpaworkshop.Dao.Impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexckon.jpaworkshop.Dao.BookLonDao;
import se.lexckon.jpaworkshop.entity.BookLoan;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookLoanDaoImpl implements BookLonDao {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public BookLoan findById(int id) {
        return entityManager.find(BookLoan.class, id);
    }

    @Override
    public List<BookLoan> findAll() {
        return entityManager.createQuery("select bl from BookLoan bl", BookLoan.class)
                .getResultList();
    }

    @Override
    @Transactional
    public BookLoan create(BookLoan bookLoan) {
         entityManager.persist(bookLoan);
         return bookLoan;
    }

    @Override
    @Transactional
    public BookLoan uppDate(BookLoan bookLoan) {
        return entityManager.merge(bookLoan);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(BookLoan.class, id));

    }
}
