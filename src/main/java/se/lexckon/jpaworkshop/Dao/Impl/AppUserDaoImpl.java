package se.lexckon.jpaworkshop.Dao.Impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexckon.jpaworkshop.Dao.AppUserDao;
import se.lexckon.jpaworkshop.entity.AppUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository

public class AppUserDaoImpl implements AppUserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public AppUser findById(int id) {
        return entityManager.find(AppUser.class, id);
    }

    @Override
    public List<AppUser> findAll() {
        return entityManager
                .createQuery("select a from AppUser  a", AppUser.class)
                .getResultList();
    }

    @Override
    @Transactional
    public AppUser create() {

        return null;
    }

    @Override
    @Transactional
    public AppUser uppDate() {
        return null;
    }

    @Override
    @Transactional
    public void delete() {

    }
}
