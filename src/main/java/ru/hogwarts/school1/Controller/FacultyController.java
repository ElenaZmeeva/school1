package ru.hogwarts.school1.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school1.Service.FacultyService;
import ru.hogwarts.school1.model.Faculty;

import java.util.Collection;
import java.util.Collections;

@RestController
    @RequestMapping("/faculty")
    public class FacultyController {

        private final FacultyService facultyService;

        public FacultyController(FacultyService facultyService) {
            this.facultyService = facultyService;
        }

        @GetMapping
        public ResponseEntity<Collection<Faculty>> getAllFacultiesByColor (@RequestParam String color){
            if(color!= null&& !color.isBlank()){
                return ResponseEntity.ok (facultyService.findByColor(color));
            }
            return ResponseEntity.ok(Collections.emptyList());
        }



        @GetMapping("{id}")
        public ResponseEntity<Faculty> getFacultyInfo (@PathVariable Long id){
            Faculty faculty= facultyService.readFaculty(id);
            if (faculty== null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(faculty);
        }

        @PostMapping
        public Faculty createFaculty( @RequestBody Faculty faculty){
            return facultyService.createFaculty(faculty);
        }

        @PutMapping
        public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty){
            Faculty faculty1= facultyService.updateFaculty( faculty);
            if(faculty1==null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(faculty1);
        }

        @DeleteMapping("{id}")
        public Faculty deleteFaculty (@PathVariable Long id){
            return facultyService.deleteFaculty(id);
        }
}
