package com.erkan.ygun.springbootrestapi.services;

import com.erkan.ygun.springbootrestapi.dto.StudentDto;

import java.util.List;

public interface StudentsService {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long studentId);

    List<StudentDto> getAllStudent();

    StudentDto updateStudent(Long studentId, StudentDto updateDto);

    void deleteStudent(Long studentId);
}
