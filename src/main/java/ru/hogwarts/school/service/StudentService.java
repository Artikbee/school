package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

   private final Logger logger  = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

   public StudentService(StudentRepository studentRepository) {
      this.studentRepository = studentRepository;
   }

   public Student createStudent(Student student) { // create
     logger.info("Was invoked method for create student");
      return studentRepository.save(student);
   }

   public Student readStudent(Long id) { //find
     logger.info("Was invoked method for read student");
      return studentRepository.findById(id).orElse(null);
   }

   public Student updateStudent(Student student) { //edit
     logger.info("Was invoked method for update student");
      return studentRepository.save(student);
   }

   public void deleteStudent(Long id) { //delete
     logger.info("Was invoked method for delete student");
      studentRepository.deleteById(id);
   }

   public List<Student> filterStudent(Integer age){ // TODO: надо подумать как его прописать в репозитории
      logger.info("Was invoked method for filter student");
      return studentRepository.findByAge(age);
   }

   public List<Student> findByAgeBetween(Integer min, Integer max){
      logger.info("Was invoked method for find by age between");
      return studentRepository.findByAgeBetween(min, max);
   }

   public Faculty findFacultyByStudent(Long id){
      logger.info("Was invoked method for find faculty by student");
      Student student = studentRepository.findById(id).orElse(null);
      if (student == null){
         return null;
      }
      return student.getFaculty();
   }

   public List<Student> findAllStudent (){
     logger.info("Was invoked method for find all student");
      return studentRepository.findAll();
   }

   public StudentCountAllStudent  getCount() {
     logger.info("Was invoked method for get count");
      return studentRepository.getCount();
   }

   public AvgAgeOfStudent getAgv(){
     logger.info("Was invoked method for get agv");
      return studentRepository.getAgv();
   }

   public Collection<LastFiveStudents> getLastFive(){
     logger.info("Was invoked method for get last five");
      return studentRepository.getLastFive();
   }

}
