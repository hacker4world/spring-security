package com.group.security.student;

import com.group.security.student.dto.LoginDto;
import com.group.security.student.dto.SignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("login")
    public String login(@RequestBody LoginDto loginData) {
        return studentService.login(loginData);
    }

    @PostMapping("signup")
    public String signup(@RequestBody SignupDto signupData) {
        return studentService.signup(signupData);
    }

    @PostMapping("reset-password")
    public String resetPassword() {
        return "Reset Password";
    }

    @GetMapping("create")
    public String createStudent() {
        return "Protected route";
    }


}