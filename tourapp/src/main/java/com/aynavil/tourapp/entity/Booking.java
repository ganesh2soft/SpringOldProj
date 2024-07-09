package com.aynavil.tourapp.entity;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tbl_booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingid;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="travellercode", referencedColumnName="custid")
	private Customer cust;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="packagecode", referencedColumnName="packageid")
	private TourPackages tourpackages;
	
	@Column(nullable = false)
	private int noofadults;
	
	@Column(nullable = false)
	private int noofchildren;
	
	@Column(nullable=false)
	private Date checkindate;
	
	@Column(nullable=false)
	private Date checkoutdate;
	
	@Column(nullable=false)
	private Boolean isvalidpassport;

	@Column(nullable=false)
	private String vacationtype; //HoneyMoon, FriendsTrip, FamilyOuting, CorporateTour

}
