package se.lexckon.jpaworkshop.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "DB_Details")

public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false) // if you do not want to update the id
    private int detailsId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    private LocalDate birthDate;

    public Details() {
        this.detailsId = detailsId;
        this.birthDate = birthDate;
    }

    public Details(String name, String email) {
        this();
        this.email = email;
        this.name = name;
    }

    public int getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Details details = (Details) o;
        return detailsId == details.detailsId && name.equals(details.name) && email.equals(details.email) && Objects.equals(birthDate, details.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detailsId, name, email, birthDate);
    }
}
