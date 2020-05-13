package com.shanggushenlong.springbootview.springboot_thymeleaf.controller;

import com.shanggushenlong.springbootview.springboot_thymeleaf.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

/**
 * springboot整合thymeleaf
 */
@Controller
public class StudentController {

    @GetMapping("/student")
    public String stu(Model model){
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0 ;i < 10 ; i++) {
            Student student = new Student();
            student.setId(i);
            student.setUsername("shanggushenlong>>" + i);
            student.setAge(String.valueOf(i));
            students.add(student);
        }

        model.addAttribute("students",students);
        return "student";
    }
}
