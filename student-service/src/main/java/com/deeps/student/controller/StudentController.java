package com.deeps.student.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.deeps.student.entity.Book;
import com.deeps.student.client.BookServiceClient;
import com.deeps.student.entity.Student;
import com.deeps.student.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @Autowired
    private BookServiceClient bookServiceClient;

    @PostMapping("/addstudent")
    public Student saveStudent(@RequestBody Student student) {
        System.out.println("Inside saveStudent method of StudentController"+ student);
        return  studentService.saveStudent(student);
    }

    @GetMapping("/findstudent/{id}")
    public Student findStudentById(@PathVariable("id") Long studentId) {
    	System.out.println("Inside findStudentById method of StudentController");
        return studentService.findStudentById(studentId);
    }
    
    @GetMapping("/allstudent")
    public List<Student> getAllStudent() {
    	return studentService.getAllStudent();
    }
    
    @GetMapping("/findbooksbyid/{bid}")
    public Book findBooksById(@PathVariable("bid") Long bookId) {
    	System.out.println("Inside findBooksById method of StudentController");    	
        return bookServiceClient.getBookById(bookId);
    }

    @GetMapping("/findlistofallbooks")
    public List<Book> findListOfAllBooks() {
    	System.out.println("Inside findListOfAllBooks method of StudentController");    	
        return bookServiceClient.getAllBooks();
    }
}
