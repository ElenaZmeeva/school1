package ru.hogwarts.school1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school1.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
List<Student>findByAge(int age);

List<Student> findByAgeBetween( int min, int max);

@Query( value = "SELECT COUNT (*) FROM student", nativeQuery = true)
    long getStudentAmount();

@Query(value = "SELECT AVG (age) AS avg FROM student", nativeQuery = true)
    double getAverageAge();

@Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT 5 ", nativeQuery = true)
    List<Student> getLastStudents();
}
