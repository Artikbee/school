package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.entity.AvgAgeOfStudent;
import ru.hogwarts.school.entity.LastFiveStudents;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.entity.StudentCountAllStudent;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.List;

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

   public List<Student> filterStudent(Integer age){ // TODO: надо подумать как его прописать в репозитории
      return studentRepository.findByAge(age);
   }

   public List<Student> findByAgeBetween(Integer min, Integer max){
      return studentRepository.findByAgeBetween(min, max);
   }

   public Faculty findFacultyByStudent(Long id){
      Student student = studentRepository.findById(id).orElse(null);
      if (student == null){
         return null;
      }
      return student.getFaculty();
   }

   public List<Student> findAllStudent (){
      return studentRepository.findAll();
   }

   public StudentCountAllStudent countAllStudent() {
      return studentRepository.countAllStudent();
   }

   public AvgAgeOfStudent avgAgeOfStudent(){
      return studentRepository.avgAgeOfStudent();
   }

   public Collection<LastFiveStudents> lastFiveStudents(){
      return studentRepository.getLastFive();
   }

}
