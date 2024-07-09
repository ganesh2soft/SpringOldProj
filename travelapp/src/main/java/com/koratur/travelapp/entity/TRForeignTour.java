package com.koratur.travelapp.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tbl_foreign")
public class TRForeignTour {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long foreignid;
	@Column(nullable = false)
	private String country;
	@Column(nullable = false)
	private long noofpeople;
	@Column(nullable = false)
	private boolean isPassportValid;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="travellercode", referencedColumnName="travellerid")
	private TRTraveller trtourist;
}
