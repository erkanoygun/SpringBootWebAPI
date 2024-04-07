package com.erkan.ygun.springbootrestapi.services.impl;

import com.erkan.ygun.springbootrestapi.dto.StudentDto;
import com.erkan.ygun.springbootrestapi.entitiy.Student;
import com.erkan.ygun.springbootrestapi.exception.ResourceNotFoundException;
import com.erkan.ygun.springbootrestapi.mapper.StudentMapper;
import com.erkan.ygun.springbootrestapi.repository.StudentsRepository;
import com.erkan.ygun.springbootrestapi.services.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudentsServiceImpl implements StudentsService {

    private StudentsRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student is not exist with given id: " + studentId));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();

        return students.stream().map(StudentMapper::mapToStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updateDto) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException(("Student is not exists with given id: " + studentId))
        );

        student.setName(updateDto.getFirstName());
        student.setLastName(updateDto.getLastName());
        student.setEmail(updateDto.getEmail());

        Student updateStudent = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(updateStudent);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException(("Student is not exists with given id: " + studentId))
        );

        studentRepository.deleteById(studentId);
    }
}
