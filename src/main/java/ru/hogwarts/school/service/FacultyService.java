package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final Map<Long, Faculty> faculties = new HashMap<>();
    private long counter = 0;

    public Faculty createFaculty(Faculty faculty) { // create
        faculty.setId(++counter);
        faculties.put(counter, faculty);
        return faculty;
    }

    public Faculty readFaculty(Long id) { //find
        return faculties.get(id);
    }

    public Faculty updateFaculty(Faculty faculty) { //edit

        if (faculties.containsKey(faculty.getId())) {
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Faculty deleteFaculty(Long id) { //delete
        return faculties.remove(id);
    }

    public Collection<Faculty> filterFaculties(String color){
        return faculties.values().stream()
                .filter(f -> f.getColor().equals(color))
                .collect(Collectors.toList());
    }


}
