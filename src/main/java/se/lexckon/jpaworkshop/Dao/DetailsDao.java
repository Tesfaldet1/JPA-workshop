package se.lexckon.jpaworkshop.Dao;

import se.lexckon.jpaworkshop.entity.AppUser;
import se.lexckon.jpaworkshop.entity.Details;

import java.util.List;

public interface DetailsDao {
    Details findById(int id);
    List<Details> findAll();
    Details create();
    Details uppDate();
    void delete();
}
