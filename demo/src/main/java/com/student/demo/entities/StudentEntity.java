package com.student.demo.entities;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Table(name="students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)

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
