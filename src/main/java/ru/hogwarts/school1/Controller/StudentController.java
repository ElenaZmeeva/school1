package ru.hogwarts.school1.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school1.Service.StudentService;
import ru.hogwarts.school1.model.Student;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

@RestController
    @RequestMapping("/student")
    public class StudentController {

        private final StudentService studentService;

        public StudentController(StudentService studentService) {
            this.studentService = studentService;
        }

        @GetMapping("/age")
        public ResponseEntity<Collection<Student>> getAllStudentsByAge (@PathVariable int age){
            if(age>0){
                return ResponseEntity.ok (studentService.studentsByAge(age));
            }
            return ResponseEntity.ok (Collections.emptyList());
        }
        @GetMapping
        public ResponseEntity<Collection<Student>> getByAgeBetween (@RequestParam int min,
                                                                @RequestParam int max){
            return ResponseEntity.ok(studentService.findByAgeBetween(min,max));
    }

        @GetMapping("{id}")
        public ResponseEntity<Student> getStudentInfo (@PathVariable Long id){
            Student student= studentService.readStudent(id);
            if (student == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(student);
        }

        @PostMapping
        public Student createStudent( @RequestBody Student student){
            return studentService.createStudent(student);
        }

        @PutMapping
        public ResponseEntity<Student> updateStudent(@RequestBody Student student){
            Student student1= studentService.updateStudent(student);
            if(student1==null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(student1);
        }

        @DeleteMapping("{id}")
        public ResponseEntity<Void> deleteStudent (@PathVariable Long id){
           studentService.deleteStudent(id);
            return ResponseEntity.ok().build();
        }

        @GetMapping("/get_amount")
        public long getStudentAmount(){
            return studentService.getStudentAmount();
        }

        @GetMapping("/get_average_age")
        public double getAverageAge(){
            return studentService.getAverageAge();
        }

        @GetMapping("/last_students")
        public List<Student> getLastStudents (){
            return studentService.getLastStudents();
        }


        @GetMapping("/names")
        public List<String> studentsNameBeginA (){
            return studentService.studentsNameBeginA();
        }

        @GetMapping("/average_age")
        public double studentsAverageAge(){
            return studentService.studentsAverageAge();
        }
    }
