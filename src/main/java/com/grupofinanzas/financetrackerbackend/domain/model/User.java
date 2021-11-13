package com.grupofinanzas.financetrackerbackend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull
    private String Name;
    @NotNull
    private String fatherSurname;
    @NotNull
    private String motherSurname;
    @NotNull
    private String password;
    @NotNull
    private String email;
    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Cartera> Cartera = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFatherSurname() {
        return fatherSurname;
    }

    public void setFatherSurname(String fatherSurname) {
        this.fatherSurname = fatherSurname;
    }

    public String getMotherSurname() {
        return motherSurname;
    }

    public void setMotherSurname(String motherSurname) {
        this.motherSurname = motherSurname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<com.grupofinanzas.financetrackerbackend.domain.model.Cartera> getCartera() {
        return Cartera;
    }

    public void setCartera(List<com.grupofinanzas.financetrackerbackend.domain.model.Cartera> cartera) {
        Cartera = cartera;
    }
}