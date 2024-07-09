package com.koratur.travelapp.entity;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
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
@Table(name = "tbl_local")
public class TRLocalTour {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long localid;

	@Column(nullable=false)
	private String location;
	@Column(nullable = false)
	private long noofpeople;
    

	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="travellercode", referencedColumnName="travellerid")
	private TRTraveller trtourist;

}
