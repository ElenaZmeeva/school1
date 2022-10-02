package ru.hogwarts.school1.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school1.Repository.StudentRepository;
import ru.hogwarts.school1.model.Student;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
    public class StudentService {

    private final Logger logger= LoggerFactory.getLogger(StudentService.class);
        private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }

    public Student createStudent (Student student){
        logger.info("Was invoked method for create student");
            return studentRepository.save(student);
        }
    public Student readStudent (long id){
         logger.info("Was invoked method for find student");
            return studentRepository.findById(id).orElse(null);
        }

    public Student updateStudent (Student student){
         logger.info("Was invoked method for update student");
            return studentRepository.save(student);
        }

    public void deleteStudent (long id){
        logger.info("Was invoked method for delete student");
           studentRepository.deleteById(id);
        }

    public Collection<Student> studentsByAge(int age) {
        logger.info("Was invoked method for find student by age");
            return studentRepository.findByAge(age);
        }

    public Collection<Student> findByAgeBetween(int min, int max) {
        logger.info("Was invoked method for find student by age between");
        return studentRepository.findByAgeBetween(min, max);
    }

    public long getStudentAmount(){
        logger.info("Was invoked method for get amount student");
       return studentRepository.getStudentAmount();
    }

    public double getAverageAge(){
        logger.info("Was invoked method for get average age");
        return studentRepository.getAverageAge();
    }

    public List<Student> getLastStudents(){
        logger.info("Was invoked method for get last students");
        return studentRepository.getLastStudents();
    }

    public List<String> studentsNameBeginA (){
        return studentRepository.findAll()
                .stream()
                .filter((s -> s.getName().contains("A")))
                .map(s -> s.getName().toUpperCase())
                .sorted()
                .collect(Collectors.toList());
}

    public double studentsAverageAge(){
        return studentRepository.findAll()
            .stream()
            .mapToDouble(Student::getAge)
            .average().orElse(0);
}

    public void  allStudentsWithThread(){
        printStudents(1);
        printStudents(2);

    new Thread(()->{
        printStudents(3);
        printStudents(4);
    }).start();

    new Thread(()->{
        printStudents(5);
        printStudents(6);
    }).start();

}
    public void printStudents(long id){
        studentRepository.findById(id);
    System.out.println("Student" + id+ "Count"+ count);
}
    public Integer count=0;
    public void printStudentsSynchronized(long id){
        synchronized (Student.class){
            printStudents(id);
            count++;
        }
    }

    public void  allStudentsWithSynchronized() {
        printStudentsSynchronized(1);
        printStudentsSynchronized(2);

        new Thread(() -> {
            printStudentsSynchronized(3);
            printStudentsSynchronized(4);
        }).start();

        new Thread(() -> {
            printStudentsSynchronized(5);
            printStudentsSynchronized(6);
        }).start();
    }

}
