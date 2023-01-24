package se.lexckon.jpaworkshop.Dao.Impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public Details create(Details details) {
        entityManager.persist(details);
        return details;
    }

    @Override
    @Transactional(readOnly = true)
    public Details uppDate(Details details) {

        return  entityManager.merge(details);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(Details.class, id));
    }

}
