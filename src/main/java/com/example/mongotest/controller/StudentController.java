package com.example.mongotest.controller;

import com.example.mongotest.mapper.StudentMapper;
import com.example.mongotest.model.Student;
import com.example.mongotest.model.dto.StudentCreateDto;
import com.example.mongotest.model.dto.StudentUpdateDto;
import com.example.mongotest.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(description = "create new student by given json")
    @PostMapping
    public ResponseEntity<Student> create(@RequestBody StudentCreateDto studentCreateDto) {
        Student newStudent = studentService.create(studentMapper.toModel(studentCreateDto));
        return ResponseEntity.ok(newStudent);
    }

    @Operation(description = "get student by id")
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable String id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @Operation(description = "get all students with pagination and sort. "
            + "NOTE: sort must be formatted like field1,field2, ...")
    @GetMapping
    public ResponseEntity<List<Student>> getAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit,
            @RequestParam(required = false) Optional<String> sort
    ) {
        return ResponseEntity.ok(studentService.getAll(page, limit, sort));
    }

    @Operation(description = "update whole student by given json")
    @PutMapping
    public ResponseEntity<Student> update(@RequestBody StudentUpdateDto studentUpdateDto) {
        Student updatedStudent = studentService.update(studentMapper.toModel(studentUpdateDto));
        return ResponseEntity.ok(updatedStudent);
    }

    @Operation(description = "delete student by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(studentService.deleteById(id));
    }

    @Operation(description = "find all students by name")
    @GetMapping("/findByName")
    public ResponseEntity<List<Student>> getAllByName(@RequestParam String name) {
        return ResponseEntity.ok(studentService.getAllByName(name));
    }

    @Operation(description = "find all students by name AND email")
    @GetMapping("/findByNameAndEmail")
    public ResponseEntity<List<Student>> getAllByNameAndEmail(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        return ResponseEntity.ok(studentService.getAllByNameAndEmail(name, email));
    }

    @Operation(description = "find all students by name OR email")
    @GetMapping("/findByNameOrEmail")
    public ResponseEntity<List<Student>> getAllByNameOrEmail(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        return ResponseEntity.ok(studentService.getAllByNameOrEmail(name, email));
    }

    @Operation(description = "find all students by department name")
    @GetMapping("/findByDepartmentName")
    public ResponseEntity<List<Student>> getAllByDepartmentName(@RequestParam String departmentName) {
        return ResponseEntity.ok(studentService.getAllByDepartmentName(departmentName));
    }

    @Operation(description = "find all students by subject name")
    @GetMapping("/findBySubjectName")
    public ResponseEntity<List<Student>> getAllBySubjectName(@RequestParam String subjectName) {
        return ResponseEntity.ok(studentService.getAllBySubjectName(subjectName));
    }

    @Operation(description = "find all students by email LIKE")
    @GetMapping("/findByEmailLike")
    public ResponseEntity<List<Student>> getAllByEmailLike(@RequestParam String email) {
        return ResponseEntity.ok(studentService.getAllByEmailLike(email));
    }

    @Operation(description = "find all students by name STARTS WITH")
    @GetMapping("/findByNameStartsWith")
    public ResponseEntity<List<Student>> getAllByNameStartsWith(@RequestParam String name) {
        return ResponseEntity.ok(studentService.getAllByNameStartsWith(name));
    }
}
