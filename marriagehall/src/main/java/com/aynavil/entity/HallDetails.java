package com.aynavil.entity;



@javax.persistence.Entity
public class HallDetails {
	
	
	private String hall_name;
	private String hall_desc;
	private String hall_type;
	private int hall_charge;
	public HallDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HallDetails(String hall_name, String hall_desc, String hall_type, int hall_charge) {
		super();
		this.hall_name = hall_name;
		this.hall_desc = hall_desc;
		this.hall_type = hall_type;
		this.hall_charge = hall_charge;
	}
	public String getHall_name() {
		return hall_name;
	}
	public void setHall_name(String hall_name) {
		this.hall_name = hall_name;
	}
	public String getHall_desc() {
		return hall_desc;
	}
	public void setHall_desc(String hall_desc) {
		this.hall_desc = hall_desc;
	}
	public String getHall_type() {
		return hall_type;
	}
	public void setHall_type(String hall_type) {
		this.hall_type = hall_type;
	}
	public int getHall_charge() {
		return hall_charge;
	}
	public void setHall_charge(int hall_charge) {
		this.hall_charge = hall_charge;
	}
	@Override
	public String toString() {
		return "HallDetails [hall_name=" + hall_name + ", hall_desc=" + hall_desc + ", hall_type=" + hall_type
				+ ", hall_charge=" + hall_charge + "]";
	}
	
	

}
