package com.example.mongotest.model.dto;

import com.example.mongotest.model.Department;
import com.example.mongotest.model.Subject;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class StudentCreateDto {
    private String name;
    private String email;
    private Department department;
    private List<Subject> subjects;
}
