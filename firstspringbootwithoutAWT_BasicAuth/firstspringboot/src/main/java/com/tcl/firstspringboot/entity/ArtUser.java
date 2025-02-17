package com.tcl.firstspringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ArtUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    @Column(nullable = false,unique=true)
    private String username;
    private String password;
    
@Column
	
	private String roles;
}
