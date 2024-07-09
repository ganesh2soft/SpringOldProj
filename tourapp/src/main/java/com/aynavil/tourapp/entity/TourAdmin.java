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
@Table(name = "tbl_touradmin")
public class TourAdmin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long touradminid;
	@Column(nullable = false,unique=true)
	private String touradminname;
	@Column(nullable = false)
	private String touradminpwd;
	@Column(nullable = false)
	private String roles;
}
