package se.lexckon.jpaworkshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexckon.jpaworkshop.Dao.AppUserDao;
import se.lexckon.jpaworkshop.Dao.BookDao;
import se.lexckon.jpaworkshop.Dao.BookLonDao;
import se.lexckon.jpaworkshop.Dao.DetailsDao;
import se.lexckon.jpaworkshop.entity.AppUser;
import se.lexckon.jpaworkshop.entity.BookLoan;
import se.lexckon.jpaworkshop.entity.Details;
import  se.lexckon.jpaworkshop.entity.Book;
import java.time.LocalDate;

@Component
public class AppCommandLineRunner implements CommandLineRunner {
    @Autowired
    AppUserDao appUserDao;
    @Autowired
    DetailsDao detailsDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    BookLonDao bookLonDao;
    @Override
    @Transactional
    public void run(String... args) throws Exception {

test2();

    }
    public  void test1(){
        Details detailsData = new Details("Tesfaldet", "tweldemicheal@gmail.com",
                LocalDate.parse("1989-10-10"));
        Details createdDetails = detailsDao.create(detailsData);

        AppUser appUserData = new AppUser("Nuna", "nuna123", LocalDate.now(),detailsData);
        AppUser createdAppUser = appUserDao.create(appUserData);





        appUserData.setDetails(createdDetails);
        System.out.println(createdAppUser);

       // appUserDao.delete(createdAppUser.getAppUserId());

    }
    public void test2(){
        AppUser appUserData = new AppUser("Nuna", "nuna123", LocalDate.now(), new Details("Tesfaldet", "tweldemicheal@gmail.com",
                LocalDate.parse("1989-10-10")));
        AppUser createdAppUser = appUserDao.create(appUserData);
        Details detailsdata = detailsDao.findById(1);

        BookLoan bookLoandata = new BookLoan(LocalDate.parse("2023-10-10"),true );

        bookLoandata.UserLoanBook(createdAppUser);
       // bookLoandata.returnUserBook();

        Book JavaBookData = new Book("1-292-02819-4","Java how to program", 15,
                bookLoandata);
        Book  MicrosoftBookData = new Book("978938898767","Microsoft Azure Administrator Exam",
                16,bookLoandata);


       JavaBookData.setListOfBook(createdAppUser.getLoan());
       MicrosoftBookData.setListOfBook(createdAppUser.getLoan());


        Book createdJavaBookData= bookDao.create(JavaBookData);
        Book createdBook1 = bookDao.create(MicrosoftBookData);

        }




    public void test3(){


    }
}
