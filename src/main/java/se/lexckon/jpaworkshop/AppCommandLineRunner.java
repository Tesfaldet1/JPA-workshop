package se.lexckon.jpaworkshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexckon.jpaworkshop.Dao.*;
import se.lexckon.jpaworkshop.entity.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
    @Autowired
    AuthorDao authorDao;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

     test1();

    }

    public void test2(){
        AppUser appUserData = new AppUser("Nuna", "nuna123",
                LocalDate.now(), new Details("Tesfaldet", "tweldemicheal@gmail.com",
                LocalDate.parse("1989-10-10")));
        AppUser createdAppUser = appUserDao.create(appUserData);
        Details detailsdata = detailsDao.create(createdAppUser.getDetails());

        BookLoan bookLoandata = new BookLoan(LocalDate.parse("2023-10-10"),true );
        BookLoan createdBookLoan = bookLonDao.create(bookLoandata);

        bookLoandata.setBorrower(createdAppUser);
        Author authorData = new Author("Test","test");
        Author createdAuthor = authorDao.create(authorData);
        createdAuthor.getWrittenBooks();


        Book JavaBookData = new Book("1-292-02819-4","Java how to program", 15);
        Book  MicrosoftBookData = new Book("978938898767","Microsoft Azure Administrator Exam", 15);


        MicrosoftBookData.getAuthorSet();

        Book createdJavaBookData= bookDao.create(JavaBookData);
        Book createdBook1 = bookDao.create(MicrosoftBookData);

        }

    public  void test1(){
        Details detailsData = new Details("Tesfaldet", "tweldemicheal@gmail.com",
                LocalDate.parse("1989-10-10"));
        Details createdDetails = detailsDao.create(detailsData);

        AppUser appUserData = new AppUser("Nuna", "nuna123", LocalDate.now(),detailsData);
        AppUser createdAppUser = appUserDao.create(appUserData);

        Author authorData  = new Author("test", "test");
        Author createdAuthor = authorDao.create(authorData);

        Book JavaBookData = new Book("1-292-02819-4","Java how to program", 15);
        Book  MicrosoftBookData = new Book("978938898767","Microsoft Azure Administrator Exam", 15);
        Book createdJavaBook = bookDao.create(JavaBookData);
        Book createdMicBook = bookDao.create(MicrosoftBookData);
        createdJavaBook.addAuthor(authorData);
        createdAuthor.addBook(MicrosoftBookData);

        BookLoan bookLoanData = new BookLoan(LocalDate.parse("1929-11-11"), LocalDate.now(),true,appUserData,createdJavaBook);
        BookLoan  createdBookLoan = bookLonDao.create(bookLoanData);

        createdBookLoan.setBookLoan(createdMicBook);
        createdBookLoan.setBookLoan(createdJavaBook);








        appUserData.setDetails(createdDetails);
        System.out.println(createdAppUser);

        //appUserDao.delete(createdAppUser.getAppUserId());

    }





}
