package com.example.mongotest.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
public class Department {
    @Field(name = "department_name")
    private String departmentName;
    private String location;
}
