package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty updateFaculty(Faculty faculty) { //edit
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id) { //delete
        facultyRepository.deleteById(id);
    }

    public List<Faculty> filterFaculties(String color) { // TODO: надо подумать как его прописать в репозитории
        return facultyRepository.findByColor(color);
    }

    public List<Faculty> findByNameOrColor(String nameOrColor) {
        return facultyRepository.findByNameOrColorIgnoreCase(nameOrColor, nameOrColor);
    }

    public Faculty findFaculty(Long id){
        return facultyRepository.findById(id).orElse(null); // поиск id фака
    }

    public List<Student> findStudentsByFaculty(Long id){
        Faculty faculty = findFaculty(id); // найденый фак по id
        List<Student> students = new ArrayList<>();
        if(faculty != null){
            return faculty.getStudents();
        }
        return students;
    }


}
