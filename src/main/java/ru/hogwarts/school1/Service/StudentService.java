package ru.hogwarts.school1.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school1.Repository.StudentRepository;
import ru.hogwarts.school1.model.Student;
import java.util.Collection;
import java.util.List;


@Service
    public class StudentService {
        private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }

    public Student createStudent (Student student){
            return studentRepository.save(student);
        }
        public Student readStudent (long id){
            return studentRepository.findById(id).orElse(null);
        }

        public Student updateStudent (Student student){
            return studentRepository.save(student);
        }

        public void deleteStudent (long id){
           studentRepository.deleteById(id);
        }

        public Collection<Student> studentsByAge(int age) {
            return studentRepository.findByAge(age);
        }

    public Collection<Student> findByAgeBetween(int min, int max) {
        return studentRepository.findByAgeBetween(min, max);
    }

    public long getStudentAmount(){
       return studentRepository.getStudentAmount();
    }

    public double getAverageAge(){
        return studentRepository.getAverageAge();
    }

    public List<Student> getLastStudents(){
        return studentRepository.getLastStudents();
    }
}
