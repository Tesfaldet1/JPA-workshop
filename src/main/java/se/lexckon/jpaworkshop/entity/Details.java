package se.lexckon.jpaworkshop.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
//@Table(name = "DB_Details")

public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false) // if you do not want to update the id
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    private LocalDate birthDate;
    @OneToOne(mappedBy = "details")
    private AppUser appUser;

    public Details() {
    }

    public Details(String name, String email) {
        this();
        this.email = email;
        this.name = name;
    }

    public Details( String name, String email, LocalDate birthDate, AppUser appUser) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.appUser = appUser;
    }

    public int getDetailsId() {
        return id;
    }

    public void setDetailsId(int detailsId) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Details details = (Details) o;
        return id == details.id && name.equals(details.name) && email.equals(details.email) && Objects.equals(birthDate, details.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, birthDate);
    }
}
