package se.lexckon.jpaworkshop.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
}
