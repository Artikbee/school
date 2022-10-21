package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.model.StudentCountAllStudent;
import ru.hogwarts.school.service.StudentService;

@RestController
public class InfoByStudentController {
    private  final StudentService studentService;

    public InfoByStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/count-All-Student")
    public StudentCountAllStudent countAllStudent(){
        return studentService.countAllStudent();
    }
}
