package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.entity.AvgAgeOfStudent;
import ru.hogwarts.school.entity.LastFiveStudents;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.entity.StudentCountAllStudent;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByAge(int age);

    List<Student> findByAgeBetween(Integer min, Integer max);

    Student getById(Long id);

    @Query(value = "select count(*) as countAllStudent from student",
            nativeQuery = true)
    StudentCountAllStudent countAllStudent();

    @Query(value = "SELECT round(AVG(age)) as avg FROM student",
            nativeQuery = true)
    AvgAgeOfStudent avgAgeOfStudent();

    @Query(value = "SELECT name as studentName FROM student ORDER BY id desc limit 5",
            nativeQuery = true)
    Collection<LastFiveStudents> getLastFive();

}
