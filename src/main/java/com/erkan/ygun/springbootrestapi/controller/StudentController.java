package com.erkan.ygun.springbootrestapi.controller;

import com.erkan.ygun.springbootrestapi.dto.StudentDto;
import com.erkan.ygun.springbootrestapi.entitiy.Student;
import com.erkan.ygun.springbootrestapi.services.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentsService studentsService;

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto savedStudent = studentsService.createStudent((studentDto));
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId){
        StudentDto studentDto = studentsService.getStudentById(studentId);
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> students = studentsService.getAllStudent();
        return ResponseEntity.ok(students);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long studentId, @RequestBody StudentDto updateStudentDto){
        StudentDto studentDto = studentsService.updateStudent(studentId, updateStudentDto);
        return ResponseEntity.ok(studentDto);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId){
        studentsService.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted successful");
    }


}
