package se.lexckon.jpaworkshop.Dao.Impl;

import org.springframework.stereotype.Repository;
import se.lexckon.jpaworkshop.Dao.DetailsDao;
import se.lexckon.jpaworkshop.entity.Details;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DetailsDaoImpl implements DetailsDao {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Details findById(int id) {
        return entityManager.find(Details.class, id);
    }

    @Override
    public List<Details> findAll() {
        return entityManager
                .createQuery("select d from Details d", Details.class)
                .getResultList();
    }

    @Override
    public Details create() {
        return null;
    }

    @Override
    public Details uppDate() {
        return null;
    }

    @Override
    public void delete() {

    }
    // todo
}
