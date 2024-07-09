package com.koratur.travelapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "tbl_traveller")
public class TRTraveller {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long travellerid;
	@Column(nullable = false,unique=true)
	private String travellername;
	@Column(nullable = false)
	private String travellerpwd;
	@Column(nullable = false)
	private String roles;

}
