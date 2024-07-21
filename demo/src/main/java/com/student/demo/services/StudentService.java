package com.student.demo.services;

import com.student.demo.dto.StudentDTO;
import com.student.demo.entities.StudentEntity;
import com.student.demo.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
final StudentRepository studentrepository;
final ModelMapper modelMapper;
public  StudentService(StudentRepository studentrepository, ModelMapper modelMapper){
        this.studentrepository=studentrepository;
    this.modelMapper = modelMapper;
}
    public StudentDTO getStudentId(Long id){
StudentEntity studentEntity=studentrepository.getById(id);
//return new StudentDTO(studentEntity.getId(),studentEntity.getName(),studentEntity.getDateOfJoining(),studentEntity.isActive());
return modelMapper.map(studentEntity,StudentDTO.class);
    }

    public StudentDTO createNewStudent(StudentDTO studentDTO) {

StudentEntity studentEntity=modelMapper.map(studentDTO,StudentEntity.class);
  return modelMapper.map(studentrepository.save(studentEntity),StudentDTO.class);
    }

    public List<StudentDTO> getAllStudents() {
   return studentrepository
           .findAll()
           .stream()
           .map(studentEntity -> modelMapper.map(studentEntity,StudentDTO.class)).collect(Collectors.toUnmodifiableList());
    }

    public boolean deleteStudentById(Long id) {
  boolean isPresent=studentrepository.existsById(id);
  if(!isPresent) return false;
  studentrepository.deleteById(id);
  return true;
    }

    public StudentDTO updateStudentById(Long id, StudentDTO studentDTO) {
        if (!studentrepository.existsById(id)) {

            return null;
        }

        StudentEntity existingStudentEntity = studentrepository.getById(id);
        existingStudentEntity.setName(studentDTO.getName());
        existingStudentEntity.setDateOfJoining(studentDTO.getDateOfJoining());
        existingStudentEntity.setActive(studentDTO.isActive());

        return modelMapper.map(studentrepository.save(existingStudentEntity), StudentDTO.class);
    }
}
