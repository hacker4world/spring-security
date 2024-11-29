package com.group.security.authentication;

import com.group.security.authentication.dto.LoginDto;
import com.group.security.authentication.dto.SignupDto;
import com.group.security.authentication.entities.Student;
import com.group.security.authentication.exceptions.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    @Autowired
    public StudentService(StudentRepository studentRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public String signup(SignupDto studentData) {
        if (studentRepository.existsByEmail(studentData.getEmail())) throw new EmailExistsException();

        Student newStudent = new Student(studentData.getFirstName(), studentData.getLastName(), studentData.getEmail(), studentData.getPassword(), 20);

        studentRepository.save(newStudent);

        return "signup successful";
    }

    public HashMap<String, String> login(LoginDto studentData) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(studentData.getEmail(), studentData.getPassword()));

        String token = jwtUtil.generateToken(studentData.getEmail());

        HashMap<String, String> map = new HashMap<>();
        map.put("token", token);

        return map;

    }
}
