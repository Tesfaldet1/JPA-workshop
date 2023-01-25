package se.lexckon.jpaworkshop.Dao.Impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexckon.jpaworkshop.Dao.AppUserDao;
import se.lexckon.jpaworkshop.Dao.AuthorDao;
import se.lexckon.jpaworkshop.entity.AppUser;
import se.lexckon.jpaworkshop.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository

public class AuthorDaoImpl implements AuthorDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override

    public Author findById(int id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public List<Author> findAll() {
        return entityManager
                .createQuery("select a from Author  a", Author.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Author create(Author author) {
        entityManager.persist(author);
        return author;
    }

    @Override
    @Transactional
    public Author uppDate(Author author) {
        return  entityManager.merge(author);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(Author.class, id));

    }
}
