package com.group.security.student;

import jakarta.persistence.Entity;
@Entity
public class Student extends User {

    public String classe;

    public Student() {

    }

    public Student(String name, String email, String password, String classe) {
        super(name, email, password);
        this.classe = classe;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
}
