package com.aynavil.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@javax.persistence.Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingid;
	private String bookingname;
	private Date fromdate;
	private Date todate;
	private int totalguest;
	private String services;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(int bookingid, String bookingname, Date fromdate, Date todate, int totalguest, String services) {
		super();
		this.bookingid = bookingid;
		this.bookingname = bookingname;
		this.fromdate = fromdate;
		this.todate = todate;
		this.totalguest = totalguest;
		this.services = services;
	}
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public String getBookingname() {
		return bookingname;
	}
	public void setBookingname(String bookingname) {
		this.bookingname = bookingname;
	}
	public Date getFromdate() {
		return fromdate;
	}
	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}
	public Date getTodate() {
		return todate;
	}
	public void setTodate(Date todate) {
		this.todate = todate;
	}
	public int getTotalguest() {
		return totalguest;
	}
	public void setTotalguest(int totalguest) {
		this.totalguest = totalguest;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ", bookingname=" + bookingname + ", fromdate=" + fromdate
				+ ", todate=" + todate + ", totalguest=" + totalguest + ", services=" + services + "]";
	}
	

}
