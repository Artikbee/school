package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

   public StudentService(StudentRepository studentRepository) {
      this.studentRepository = studentRepository;
   }

   public Student createStudent(Student student) { // create
      return studentRepository.save(student);
   }

   public Student readStudent(Long id) { //find
      return studentRepository.findById(id).get();
   }

   public Student updateStudent(Student student) { //edit
      return studentRepository.save(student);
   }

   public void deleteStudent(Long id) { //delete
      studentRepository.deleteById(id);
   }

   public Collection<Student> filterStudent(int age){
      return studentRepository.findAll().stream()
              .filter(s -> s.getAge() == age)
              .collect(Collectors.toList());
   }
}
