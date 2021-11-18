package com.grupofinanzas.financetrackerbackend.resource.user;

import javax.validation.constraints.NotNull;

public class SaveUserResource {

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

}
