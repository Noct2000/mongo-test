package com.example.mongotest.service;

import com.example.mongotest.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student create(Student student);

    Student getById(String id);

    List<Student> getAll(Integer page, Integer limit, Optional<String> sortKeys);

    Student update(Student student);

    Boolean deleteById(String id);

    List<Student> getAllByName(String name);

    List<Student> getAllByNameAndEmail(String name, String email);

    List<Student> getAllByNameOrEmail(String name, String email);

    List<Student> getAllByDepartmentName(String departmentName);

    List<Student> getAllBySubjectName(String subjectName);

    List<Student> getAllByEmailLike(String email);

    List<Student> getAllByNameStartsWith(String name);
}
