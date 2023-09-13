package com.example.mydemo.dto.requestDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequestDto {
    @JsonProperty("student_id")
    private long id;

    //we should use student_name as json while using postman
    @JsonProperty("student_name")
    private String name;

}
