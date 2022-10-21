package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.StudentCountAllStudent;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByAge(int age);

    List<Student> findByAgeBetween(Integer min, Integer max);

    Student getById(Long id);

    @Query(value = "SELECT COUNT(*) AS countAllStudent FROM student",
            nativeQuery = true)
    StudentCountAllStudent countAllStudent();

}
