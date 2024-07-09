package com.deeps.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deeps.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByStudentId(Long departmentId);
}
