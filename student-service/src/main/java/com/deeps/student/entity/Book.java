package com.deeps.student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

  
    private Long bookId;
    private String bookName;
    private String bookAuthor;
    private Integer bookPrice;
    
//    @ManyToOne
//	@JoinColumn(name = "studentId",referencedColumnName = "studentId")
//	public Student student;
  
   
}
