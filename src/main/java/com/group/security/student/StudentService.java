package com.group.security.student;

import com.group.security.student.dto.LoginDto;
import com.group.security.student.dto.SignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationProvider authenticationProvider;

    @Autowired
    public StudentService(StudentRepository studentRepository, PasswordEncoder passwordEncoder, AuthenticationProvider authenticationProvider) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationProvider = authenticationProvider;
    }

    public String signup(SignupDto signupData) {
        Optional<Student> existingStudent = studentRepository.findByEmail(signupData.getEmail());

        if (existingStudent.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }

        String encodedPassword = passwordEncoder.encode(signupData.getPassword());

        Student student = new Student(
                signupData.getName(),
                signupData.getEmail(),
                encodedPassword,
                "PFE"
        );

        studentRepository.save(student);

        return "User created";
    }

    public String login(LoginDto loginData) {

        try {
            authenticationProvider.authenticate(
                    new UsernamePasswordAuthenticationToken(loginData.getEmail(), loginData.getPassword())
            );

            return "Login successful";
        } catch (Exception e) {
            return "Email or password incorrect";
        }

    }

}
