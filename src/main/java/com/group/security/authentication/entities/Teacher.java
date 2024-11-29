package com.group.security.authentication.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher extends User {
    private boolean isEmailVerified;

    public Teacher(String firstName, String lastName, String email, String password, boolean isEmailVerified) {
        super(firstName, lastName, email, password);
        this.isEmailVerified = isEmailVerified;
    }
}
