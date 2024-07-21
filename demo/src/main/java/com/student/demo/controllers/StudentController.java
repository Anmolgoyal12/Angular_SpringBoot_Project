package com.student.demo.controllers;

import com.student.demo.dto.StudentDTO;
import com.student.demo.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//operations
// GET/ students
//POST/students
//DELETE/students
//@RestController is used to define obj of this class where u can use
@RestController
//@RequestMapping(path="/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("POST/api/students")
    public StudentDTO createNewStudent(@RequestBody StudentDTO studentDTO) {
        System.out.println("Created...........");
        return studentService.createNewStudent(studentDTO);
    }

    @GetMapping("GET/api/students")
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/GET/api/students/{id}")
    public StudentDTO getStudentId(@PathVariable("id") Long studentId) {
        return studentService.getStudentId(studentId);
    }

    @DeleteMapping(path = "/DELETE/api/students/{id}")
    public boolean deleteStudentById(@PathVariable Long id) {
        return studentService.deleteStudentById(id);

    }

    @PutMapping(path = "/Put/api/students/{id}")
    public StudentDTO updateStudentById(@PathVariable("id") Long studentId, @RequestBody StudentDTO studentDTO) {
        return studentService.updateStudentById(studentId, studentDTO);
    }
}
