package com.aynavil.tourapp.entity;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tbl_tourcustomer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long custid;
	
	@Column(nullable=false)
	private String custname;
	@Column(nullable = false,unique=true)
	private String custemail;
	@Column(nullable = false)
	private String custpwd;
	@Column(nullable = false)
	private java.sql.Date dob;
	@Column(nullable = false)
	private String roles="standard"; //Standard or Premium . Default is Standard
	
}
