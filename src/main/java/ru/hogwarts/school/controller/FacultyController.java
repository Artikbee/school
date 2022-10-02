package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
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

    @PutMapping
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty){
       Faculty faculty1 = facultyService.updateFaculty(faculty);
        if(faculty1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty1);
    }

    @DeleteMapping
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long id) {
        Faculty faculty2 =  facultyService.deleteFaculty(id);
        if(faculty2 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty2);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<Collection<Faculty>> filterFaculty(@PathVariable String color) { //+
        List<Faculty> facultiesColor = new ArrayList<>(facultyService.filterFaculties(color));
        if(facultiesColor == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultiesColor);
    }
}
