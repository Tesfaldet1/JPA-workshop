package se.lexckon.jpaworkshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexckon.jpaworkshop.Dao.AppUserDao;
import se.lexckon.jpaworkshop.Dao.DetailsDao;
import se.lexckon.jpaworkshop.entity.AppUser;
import se.lexckon.jpaworkshop.entity.Details;

import java.time.LocalDate;

@Component
public class AppCommandLineRunner implements CommandLineRunner {
    @Autowired
    AppUserDao appUserDao;
    @Autowired
    DetailsDao detailsDao;
    @Override
    @Transactional
    public void run(String... args) throws Exception {

test1();

    }
    public  void test1(){
        AppUser appUserData = new AppUser("Nuna", "nuna123", LocalDate.now());
        AppUser createdAppUser = appUserDao.create(appUserData);


        Details detailsData = new Details("Tesfaldet", "tweldemicheal@gmail.com",
                LocalDate.parse("1989-10-10"),appUserData);
        Details createdDetails = detailsDao.create(detailsData);


        appUserData.setDetails(createdDetails);
        System.out.println(createdAppUser);

    }
    public void test2(){

    }
}
