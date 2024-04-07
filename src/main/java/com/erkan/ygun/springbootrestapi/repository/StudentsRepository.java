package com.erkan.ygun.springbootrestapi.repository;

import com.erkan.ygun.springbootrestapi.entitiy.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Student, Long> {
}
