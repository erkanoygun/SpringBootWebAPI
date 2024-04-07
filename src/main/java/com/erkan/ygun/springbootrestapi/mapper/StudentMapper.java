package com.erkan.ygun.springbootrestapi.mapper;

import com.erkan.ygun.springbootrestapi.dto.StudentDto;
import com.erkan.ygun.springbootrestapi.entitiy.Student;

public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(
                student.getId(),
                student.getName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    public static Student mapToStudent(StudentDto studentDto){
        return new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail()
        );
    }
}
