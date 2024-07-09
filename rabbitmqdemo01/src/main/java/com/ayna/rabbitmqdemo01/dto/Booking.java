package com.ayna.rabbitmqdemo01.dto;

public class Booking {
	String pickuplocation;
	String droplocation;
	int noofpeople;
	
	public String getPickuplocation() {
		return pickuplocation;
	}
	public void setPickuplocation(String pickuplocation) {
		this.pickuplocation = pickuplocation;
	}
	public String getDroplocation() {
		return droplocation;
	}
	public void setDroplocation(String droplocation) {
		this.droplocation = droplocation;
	}
	public int getNoofpeople() {
		return noofpeople;
	}
	public void setNoofpeople(int noofpeople) {
		this.noofpeople = noofpeople;
	}
	
	public Booking(String pickuplocation, String droplocation, int noofpeople) {
		super();
		this.pickuplocation = pickuplocation;
		this.droplocation = droplocation;
		this.noofpeople = noofpeople;
	}
	
	public Booking() {
		super();
	}
	public void setBookingId(String string) {
		// TODO Auto-generated method stub
		
	}
	
	

}
