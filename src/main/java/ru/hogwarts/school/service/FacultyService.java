package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class FacultyService {


    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) { // create
        return facultyRepository.save(faculty);
    }

    public Faculty readFaculty(Long id) { //find
        return facultyRepository.findById(id).get();
    }

    public Faculty updateFaculty(Faculty faculty) { //edit
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id) { //delete
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> filterFaculties(String color){
        return facultyRepository.findAll().stream()
                .filter(f -> f.getColor().equals(color))
                .collect(Collectors.toList());
    }


}
