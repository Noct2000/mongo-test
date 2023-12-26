package com.example.mongotest.mapper;

import com.example.mongotest.model.Department;
import com.example.mongotest.model.Student;
import com.example.mongotest.model.Subject;
import com.example.mongotest.model.dto.StudentCreateDto;
import com.example.mongotest.model.dto.StudentUpdateDto;
import com.example.mongotest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentMapper {
    private final StudentService studentService;
    public Student toModel(StudentCreateDto studentCreateDto) {
        Student student = new Student();
        Department department = studentCreateDto.getDepartment();
        student.setDepartment(department);
        student.setEmail(studentCreateDto.getEmail());
        student.setName(studentCreateDto.getName());
        List<Subject> subjects = studentCreateDto.getSubjects();
        student.setSubjects(subjects);
        return student;
    }

    public Student toModel(StudentUpdateDto studentUpdateDto) {
        Student student = studentService.getById(studentUpdateDto.getId());
        student.setSubjects(studentUpdateDto.getSubjects());
        student.setEmail(studentUpdateDto.getEmail());
        student.setDepartment(studentUpdateDto.getDepartment());
        student.setName(studentUpdateDto.getName());
        return student;
    }
}
