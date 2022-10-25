package ru.hogwarts.school1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Faculty {

    @Id
    @GeneratedValue
        private Long id;
        private String name;
        private String color;

        @JsonIgnore
        @OneToMany(mappedBy = "faculty")
    Collection<Student> students;


        public Faculty() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Faculty{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", color='" + color + '\'' +
                    '}';
        }
    }

