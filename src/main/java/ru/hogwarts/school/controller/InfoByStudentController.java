package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.entity.AvgAgeOfStudent;
import ru.hogwarts.school.entity.LastFiveStudents;
import ru.hogwarts.school.entity.StudentCountAllStudent;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
public class InfoByStudentController {
    private  final StudentService studentService;

    public InfoByStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/count-All-Student")
    public StudentCountAllStudent countAllStudent(){
        return studentService.getCount();
    }

    @GetMapping("/average-age-of-student")
    public AvgAgeOfStudent avgAgeOfStudent(){
        return studentService.getAgv();
    }

    @GetMapping("/last-five-student")
    public Collection<LastFiveStudents> lastFiveStudents(){
        return studentService.getLastFive();
    }
}
