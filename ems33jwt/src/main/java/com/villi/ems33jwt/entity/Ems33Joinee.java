package com.villi.ems33jwt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tbl_ems33_jwtdemo")
public class Ems33Joinee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long joineeId;
	@Column
	private String joineeName;
	@Column(unique = true)
	private String joineeemail;
	@Column(nullable = false)
	private String joineepassword;
	@Column
	private String joineegender;
	@Column
	private String roles;
	@Column
	private String dept;

}