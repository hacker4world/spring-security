package com.group.security.authentication;

import com.group.security.authentication.dto.LoginDto;
import com.group.security.authentication.dto.SignupDto;
import com.group.security.authentication.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("signup")
    public String signup(@RequestBody SignupDto studentData) {
        return studentService.signup(studentData);
    }

    @PostMapping("login")
    public HashMap<String, String> login(@RequestBody LoginDto studentData) {
        return studentService.login(studentData);
    }

    @PostMapping("create")
    public String create(@RequestBody Student student) {
        return "created";
    }

}
