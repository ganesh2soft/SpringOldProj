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
@Table(name = "tbl_tourpackage")
public class TourPackages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long packageid;
	
	@Column(nullable = false,unique=true)
	private String packagename;
	@Column(nullable = false)
	private String location;
	@Column(nullable = false)
	private int costperhead;
	@Column(nullable = false)
	private String packagedescription;
	@Column(nullable =false)
	private Boolean isemieligble;
	@Column(nullable =false)
	private Boolean booknowpaylater;
}
