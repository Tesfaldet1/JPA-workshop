package se.lexckon.jpaworkshop.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
//@Table(name = "DB_AppUser")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false) // if you do not want to update the id

    private  int appUserId;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    private LocalDate regDate;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "details_Id")
    private Details details;

    @OneToMany(mappedBy ="borrower",orphanRemoval = true )
    private List<BookLoan> loan;

    public AppUser() {
    }

    public AppUser(String userName, String password, LocalDate regDate, Details details) {
        this();
        this.userName = userName;
        this.password = password;
        this.regDate = regDate;
        setDetails(details);

    }

    public int getAppUserId() {
        return appUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public List<BookLoan> getLoan() {
        return loan;
    }

    public void setLoan(List<BookLoan> loan) {
        this.loan = loan;
    }

    public  void addLoanBook(BookLoan bookLoan){
        if(bookLoan == null) throw  new IllegalArgumentException("the BookLoan Data was null");
        if(loan ==null) loan = new ArrayList<>();
        loan.add(bookLoan);
        bookLoan.setBorrower(this);
    }
    public void removeBookLoan(BookLoan bookLoan){
        if(bookLoan == null) throw new IllegalArgumentException("The book loan Data was null");
        if(loan!=null) {
            bookLoan.setBorrower(null);
            loan.remove(bookLoan);
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return appUserId == appUser.appUserId && Objects.equals(userName, appUser.userName) && Objects.equals(password, appUser.password) && Objects.equals(regDate, appUser.regDate) && Objects.equals(details, appUser.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appUserId, userName, password, regDate, details);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "appUserId=" + appUserId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", regDate=" + regDate +
                ", details=" + details +
                '}';
    }
}
