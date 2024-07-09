package com.aynavil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Userdetails {

	    @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int Userid;
	    @Column(name = "User_Name", unique = true, nullable = false)
		private String Username;
		private String FirstName;
		private String LastName;
		private String Password;
		private String ConfirmPassword;
		private String Email;
		private String phone;
		private String Address;
		private String City;
		private String State;
		public Userdetails() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Userdetails(int userid, String username, String firstName, String lastName, String password,
				String confirmPassword, String email, String phone, String address, String city, String state) {
			super();
			Userid = userid;
			Username = username;
			FirstName = firstName;
			LastName = lastName;
			Password = password;
			ConfirmPassword = confirmPassword;
			Email = email;
			this.phone = phone;
			Address = address;
			City = city;
			State = state;
		}
		public int getUserid() {
			return Userid;
		}
		public void setUserid(int userid) {
			Userid = userid;
		}
		public String getUsername() {
			return Username;
		}
		public void setUsername(String username) {
			Username = username;
		}
		public String getFirstName() {
			return FirstName;
		}
		public void setFirstName(String firstName) {
			FirstName = firstName;
		}
		public String getLastName() {
			return LastName;
		}
		public void setLastName(String lastName) {
			LastName = lastName;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public String getConfirmPassword() {
			return ConfirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			ConfirmPassword = confirmPassword;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			Address = address;
		}
		public String getCity() {
			return City;
		}
		public void setCity(String city) {
			City = city;
		}
		public String getState() {
			return State;
		}
		public void setState(String state) {
			State = state;
		}
		@Override
		public String toString() {
			return "Userdetails [Userid=" + Userid + ", Username=" + Username + ", FirstName=" + FirstName
					+ ", LastName=" + LastName + ", Password=" + Password + ", ConfirmPassword=" + ConfirmPassword
					+ ", Email=" + Email + ", phone=" + phone + ", Address=" + Address + ", City=" + City + ", State="
					+ State + "]";
		}
		

	}


