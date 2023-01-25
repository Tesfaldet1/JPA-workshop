package se.lexckon.jpaworkshop.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false) // if you do not want to update the id
    private  int loanId;
    @Column(nullable = false)
    private LocalDate loanDate;
    private  LocalDate dueDate;
    private boolean returned;
    @OneToMany(mappedBy ="loan",orphanRemoval = true )
    private List<AppUser> appUserList;
    @OneToMany(mappedBy ="listOfBook",orphanRemoval = true )
    private List<Book> bookList;

    public BookLoan() {
    }

    public BookLoan(LocalDate loanDate, boolean returned) {
        this();
        this.loanDate = loanDate;
        this.returned = returned;
    }

    public BookLoan(LocalDate loanDate, LocalDate dueDate) {
        this.loanDate = loanDate;
        this.dueDate = dueDate;
    }

    public BookLoan(int loanId, LocalDate loanDate, LocalDate dueDate, boolean returned, List<BookLoan> bookLoans) {
        this.loanId = loanId;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returned = returned;
        this.bookList = bookList;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public List<AppUser> getAppUserList() {
        return appUserList;
    }

    public void setAppUserList(List<AppUser> appUserList) {
        this.appUserList = appUserList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
    public void LoanBook(Book book){
        if(book ==null) throw new IllegalArgumentException("LoanBook data was null");
        if(bookList== null) bookList = new ArrayList<>();
        bookList.add(book);
        book.setListOfBook(this);
    }
    public  void returnBook(AppUser appUser){
        if(appUser == null) throw  new IllegalArgumentException("LoanBook was null");
        if(bookList != null){
            appUser.setLoan(null);
            bookList.remove(appUser);
        }
    }
    public  void UserLoanBook(AppUser appUser){
        if(appUser==null) throw new IllegalArgumentException("the appUser data was null");
        if(appUserList!= null){
            appUser.setLoan(null);
            appUserList.add(appUser);
            appUser.setLoan(this);
        }
    }
    public void returnUserBook(AppUser appUser){
        if(appUser==null)throw new IllegalArgumentException("the App user data was null");
        if(appUserList!=null){
            appUser.setLoan(null);
            appUserList.remove(appUser);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLoan bookLoan = (BookLoan) o;
        return loanId == bookLoan.loanId && returned == bookLoan.returned && Objects.equals(loanDate, bookLoan.loanDate) && Objects.equals(dueDate, bookLoan.dueDate) && Objects.equals(appUserList, bookLoan.appUserList) && Objects.equals(bookList, bookLoan.bookList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId, loanDate, dueDate, returned, appUserList, bookList);
    }

    @Override
    public String toString() {
        return "BookLoan{" +
                "loanId=" + loanId +
                ", loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", returned=" + returned +
                ", appUserList=" + appUserList +
                ", bookList=" + bookList +
                '}';
    }
}
