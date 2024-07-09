package com.deeps.student.service;

import com.deeps.student.entity.Student;
import com.deeps.student.repository.StudentRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
    	System.out.println("Inside saveStudent of StudentService");
        return studentRepository.save(student);
    }

    public Student findStudentById(Long studentId) {
    	System.out.println("Inside saveStudent of StudentService");
        return studentRepository.findByStudentId(studentId);
    }
    public List<Student> getAllStudent() {
    	return studentRepository.findAll();
    }
    
   
}
