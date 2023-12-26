package com.example.mongotest.service;

import com.example.mongotest.model.Student;
import com.example.mongotest.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private static final String SORT_KEYS_DELIMITER = ",";
    private final StudentRepository studentRepository;

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No student entity with id = " + id));
    }

    @Override
    public List<Student> getAll(Integer page, Integer limit, Optional<String> sortKeys) {
        PageRequest pageRequest = sortKeys.isPresent()
                ? PageRequest.of(page, limit, Sort.by(sortKeys.get().split(SORT_KEYS_DELIMITER)))
                : PageRequest.of(page, limit);
        return studentRepository.findAll(pageRequest).getContent();
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Boolean deleteById(String id) {
        boolean isExistsById = studentRepository.existsById(id);
        if (isExistsById) {
            studentRepository.deleteById(id);
        }
        return isExistsById;
    }

    @Override
    public List<Student> getAllByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public List<Student> getAllByNameAndEmail(String name, String email) {
        return studentRepository.findAllByNameAndEmail(name, email);
    }

    @Override
    public List<Student> getAllByNameOrEmail(String name, String email) {
        return studentRepository.findAllByNameOrEmail(name, email);
    }

    @Override
    public List<Student> getAllByDepartmentName(String departmentName) {
        return studentRepository.findAllByDepartmentDepartmentName(departmentName);
    }

    @Override
    public List<Student> getAllBySubjectName(String subjectName) {
        return studentRepository.findAllBySubjectsSubjectName(subjectName);
    }

    @Override
    public List<Student> getAllByEmailLike(String email) {
        return studentRepository.findAllByEmailLike(email);
    }

    @Override
    public List<Student> getAllByNameStartsWith(String name) {
        return studentRepository.findAllByNameStartsWith(name);
    }
}
