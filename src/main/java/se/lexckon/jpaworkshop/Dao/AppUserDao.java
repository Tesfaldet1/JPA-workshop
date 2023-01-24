package se.lexckon.jpaworkshop.Dao;

import se.lexckon.jpaworkshop.entity.AppUser;

import java.util.List;

public interface AppUserDao {
    AppUser findById(int id);
    List<AppUser> findAll();
    AppUser create(AppUser appUser);
    AppUser uppDate(AppUser appUser);
    void delete(int id);

}
