package com.aynavil.tourapp.dto;


public class TravelTourDto {
	private String travellername;
	private Long travellerid;
	private String location;
	
	
	public TravelTourDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TravelTourDto(String travellername, Long travellerid, String location) {
		super();
		this.travellername = travellername;
		this.travellerid = travellerid;
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "TravelTourDto [travellername=" + travellername + ", travellerid=" + travellerid + ", location="
				+ location + "]";
	}
	
	public String getTravellername() {
		return travellername;
	}
	public void setTravellername(String travellername) {
		this.travellername = travellername;
	}
	public Long getTravellerid() {
		return travellerid;
	}
	public void setTravellerid(Long travellerid) {
		this.travellerid = travellerid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	
}
