-- liquibase formatted sql

-- changed elenazmeeva:1

CREATE INDEX student_name_index ON student (name);

-- changed elenazmeeva:2

CREATE INDEX faculty_name_index ON faculty(name);

CREATE INDEX faculty_color_index ON faculty(color);