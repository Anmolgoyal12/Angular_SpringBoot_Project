package com.student.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private Double age;
    private String gender;
    private String course;
    private Integer semester;
    private String stream;
    @Lob
    @Column(name = "photo", columnDefinition = "BLOB")
    private byte[] photo;
}
