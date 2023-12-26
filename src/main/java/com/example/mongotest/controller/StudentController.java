package com.example.mongotest.controller;

import com.example.mongotest.mapper.StudentMapper;
import com.example.mongotest.model.Student;
import com.example.mongotest.model.dto.StudentCreateDto;
import com.example.mongotest.model.dto.StudentUpdateDto;
import com.example.mongotest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody StudentCreateDto studentCreateDto) {
        Student newStudent = studentService.create(studentMapper.toModel(studentCreateDto));
        return ResponseEntity.ok(newStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable String id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit,
            @RequestParam(required = false) Optional<String> sort
    ) {
        return ResponseEntity.ok(studentService.getAll(page, limit, sort));
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody StudentUpdateDto studentUpdateDto) {
        Student updatedStudent = studentService.update(studentMapper.toModel(studentUpdateDto));
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(studentService.deleteById(id));
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Student>> getAllByName(@RequestParam String name) {
        return ResponseEntity.ok(studentService.getAllByName(name));
    }

    @GetMapping("/findByNameAndEmail")
    public ResponseEntity<List<Student>> getAllByNameAndEmail(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        return ResponseEntity.ok(studentService.getAllByNameAndEmail(name, email));
    }

    @GetMapping("/findByNameOrEmail")
    public ResponseEntity<List<Student>> getAllByNameOrEmail(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        return ResponseEntity.ok(studentService.getAllByNameOrEmail(name, email));
    }

    @GetMapping("/findByDepartmentName")
    public ResponseEntity<List<Student>> getAllByDepartmentName(@RequestParam String departmentName) {
        return ResponseEntity.ok(studentService.getAllByDepartmentName(departmentName));
    }

    @GetMapping("/findBySubjectName")
    public ResponseEntity<List<Student>> getAllBySubjectName(@RequestParam String subjectName) {
        return ResponseEntity.ok(studentService.getAllBySubjectName(subjectName));
    }

    @GetMapping("/findByEmailLike")
    public ResponseEntity<List<Student>> getAllByEmailLike(@RequestParam String email) {
        return ResponseEntity.ok(studentService.getAllByEmailLike(email));
    }

    @GetMapping("/findByNameStartsWith")
    public ResponseEntity<List<Student>> getAllByNameStartsWith(@RequestParam String name) {
        return ResponseEntity.ok(studentService.getAllByNameStartsWith(name));
    }
}
