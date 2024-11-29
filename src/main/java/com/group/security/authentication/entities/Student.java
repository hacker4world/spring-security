package com.group.security.authentication.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Student extends User {

    private double budget;

    public Student(String firstName, String lastName, String email, String password, double budget) {
        super(firstName, lastName, email, password);
        this.budget = budget;
    }

}
