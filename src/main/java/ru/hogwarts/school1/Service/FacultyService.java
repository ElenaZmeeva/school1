package ru.hogwarts.school1.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school1.model.Faculty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

@Service
    public class FacultyService {

        private final HashMap<Long, Faculty> faculties = new HashMap<>();
        private long id=0;

        public Faculty createFaculty (Faculty faculty){
            faculty.setId(++id);
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        public Faculty readFaculty (long id){
            return faculties.get(id);
        }

        public Faculty updateFaculty ( Faculty faculty){
            if(!faculties.containsKey(id)){
                return null;
            }
            faculties.put(id,faculty);
            return faculty;
        }

        public Faculty deleteFaculty (long id){
            return faculties.remove(id);
        }

        public Collection<Faculty> findByColor(String color){
            ArrayList<Faculty> result= new ArrayList<>();
            for (Faculty faculty: faculties.values()){
                if(Objects.equals(faculty.getColor(),color)){
                    result.add(faculty);
                }
            }
            return result;
        }

    }
