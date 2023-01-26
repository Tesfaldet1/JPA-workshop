package se.lexckon.jpaworkshop.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false) // if you do not want to update the id
    private  int loanId;
    @Column(nullable = false)
    private LocalDate loanDate;
    private  LocalDate dueDate;
    @Column(nullable = false)
    private boolean returned;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "AppUser_id")
    private AppUser borrower;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "book_id")
    private Book bookLoan;




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

    public BookLoan(int loanId, LocalDate loanDate, LocalDate dueDate, boolean returned) {
        this.loanId = loanId;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returned = returned;

    }

    public BookLoan(LocalDate loanDate, LocalDate dueDate, boolean returned, AppUser borrower, Book bookLoan) {
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returned = returned;
        this.borrower = borrower;
        this.bookLoan = bookLoan;
    }

    public BookLoan(int loanId, LocalDate loanDate, LocalDate dueDate, boolean returned, AppUser borrower, Book bookLoan) {
        this.loanId = loanId;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returned = returned;
        this.borrower = borrower;
        this.bookLoan = bookLoan;
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

    public AppUser getBorrower() {
        return borrower;
    }

    public void setBorrower(AppUser borrower) {
        this.borrower = borrower;
    }

    public Book getBook() {
        return bookLoan;
    }

    public void setBook(Book bookLoan) {
        this.bookLoan = bookLoan;
    }

    public Book getBookLoan() {
        return bookLoan;
    }

    public void setBookLoan(Book bookLoan) {
        this.bookLoan = bookLoan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLoan bookLoan = (BookLoan) o;
        return loanId == bookLoan.loanId && returned == bookLoan
                .returned && Objects.equals(loanDate, bookLoan.loanDate)
                && Objects.equals(dueDate, bookLoan.dueDate)
                && Objects.equals(borrower, bookLoan.borrower)
                && Objects.equals(bookLoan, bookLoan.bookLoan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId, loanDate, dueDate, returned);
    }

    @Override
    public String toString() {
        return "BookLoan{" +
                "loanId=" + loanId +
                ", loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", returned=" + returned +
                '}';
    }
}
