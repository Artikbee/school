package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.StudentCountAllStudent;
import ru.hogwarts.school.service.StudentService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public List<Student> findAllStudent(){
        return studentService.findAllStudent();
    }



    @PostMapping
    public Student createStudent(@RequestBody Student student) { //+
        return studentService.createStudent(student);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> readStudent(@PathVariable Long id) { //+
        Student student = studentService.readStudent(id);
        if(student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
       Student studentUpdate = studentService.updateStudent(student);
        if(studentUpdate == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentUpdate);
    }

    @DeleteMapping
    public ResponseEntity<Student>  deleteStudent(@PathVariable Long id) {//++
      studentService.deleteStudent(id);
      return ResponseEntity.ok().build();
    }

    @GetMapping("/age")
    public ResponseEntity<Collection<Student>> filterStudent(@RequestParam Integer age) { //+
       List<Student> studentsAge = new ArrayList<>(studentService.filterStudent(age));
        return ResponseEntity.ok(studentsAge);
    }

    @GetMapping(params = {"min","max"})
    public List<Student> findByAgeBetween(@RequestParam Integer min,
                                          @RequestParam Integer max){
        return studentService.findByAgeBetween(min,max);
    }

    @GetMapping("/faculty")
    public Faculty findFacultyByStudent(@RequestParam Long id){
        return studentService.findFacultyByStudent(id);
    }
}
