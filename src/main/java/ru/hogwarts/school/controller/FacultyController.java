package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> readFaculty(@PathVariable Long id) {
        Faculty faculty = facultyService.readFaculty(id);
        if(faculty == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @GetMapping(params = "nameOrColor")
    public List<Faculty> findByNameOrColor(@RequestParam String nameOrColor){
        return facultyService.findByNameOrColor(nameOrColor);
    }
    @PutMapping
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty){
       Faculty faculty1 = facultyService.updateFaculty(faculty);
        if(faculty1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty1);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/color")
    public ResponseEntity<Collection<Faculty>> filterFaculty(@RequestParam String color) { //+
        List<Faculty> facultiesColor = new ArrayList<>(facultyService.filterFaculties(color));
        return ResponseEntity.ok(facultiesColor);
    }

    @GetMapping("{id}/students")
    public ResponseEntity<List<Student>> findStudentsByFaculty(@PathVariable Long id) {
        List<Student> students = new ArrayList<>(facultyService.findStudentsByFaculty(id));
        if (students.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }

}
