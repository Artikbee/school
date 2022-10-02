package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

   private final Map<Long, Student> students = new HashMap<>();
   private long counter = 0;

   public Student createStudent(Student student) { // create
      student.setId(++counter);
      students.put(counter, student);
      return student;
   }

   public Student readStudent(Long id) { //find
      return students.get(id);
   }

   public Student updateStudent(Student student) { //edit

      if (students.containsKey(student.getId())) {
         students.put(student.getId(), student);
         return student;
      }
      return null;
   }

   public Student deleteStudent(Long id) { //delete
      return students.remove(id);
   }

   public Collection<Student> filterStudent(int age){
      return students.values().stream()
              .filter(s -> s.getAge() == age)
              .collect(Collectors.toList());
   }
}
