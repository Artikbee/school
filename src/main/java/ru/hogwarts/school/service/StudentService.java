package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.List;
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
      return studentRepository.findById(id).orElse(null);
   }

   public Student updateStudent(Student student) { //edit
      return studentRepository.save(student);
   }

   public void deleteStudent(Long id) { //delete
      studentRepository.deleteById(id);
   }

   public List<Student> filterStudent(int age){ // TODO: надо подумать как его прописать в репозитории
      return studentRepository.findByAge(age);
   }
}
