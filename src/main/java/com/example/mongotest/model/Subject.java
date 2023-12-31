package com.example.mongotest.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@Document(collection = "subject")
public class Subject {
    @Field(name = "subject_name")
    private String subjectName;
    @Field(name = "marks_obtained")
    private Integer marksObtained;
}
