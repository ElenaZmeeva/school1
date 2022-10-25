package ru.hogwarts.school1.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school1.Repository.FacultyRepository;
import ru.hogwarts.school1.model.Faculty;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

@Service
    public class FacultyService {

    private final Logger logger= LoggerFactory.getLogger(FacultyService.class);

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        logger.info("Was invoked method for create faculty");
        return facultyRepository.save(faculty);
    }

    public Faculty readFaculty(long id) {
        logger.info("Was invoked method for find faculty");
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty updateFaculty(Faculty faculty) {
        logger.info("Was invoked method for update faculty");
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        logger.info("Was invoked method for delete faculty");
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> findByColor(String color) {
        logger.info("Was invoked method for find faculty by color");
        return facultyRepository.findByColor(color);
    }

    public Collection<Faculty> findByNameIgnoreCaseOrColorIgnoreCase(String nameOrColor) {
        logger.info("Was invoked method for find faculty by color or name");
        return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(nameOrColor, nameOrColor);
    }

    public String longestFacultyName(){
      return   facultyRepository.findAll()
                .stream()
                .map(Faculty::getName)
                .max(Comparator.comparingInt(String::length))
                .get();

    }

    public Integer sum(){
         Integer sum = Stream.iterate(1, a->a+1)
                .parallel()
                .limit(1_000_000)
                .reduce(0,(a,b)->a+b);
         return sum;
    }
}
