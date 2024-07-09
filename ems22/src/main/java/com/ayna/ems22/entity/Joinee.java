package com.ayna.ems22.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_joinee_register")
public class Joinee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long joineeId;
	@Column
	private String joineeName;
	private String joineeemail;
	private String joineepassword;
	private String joineegender;
	public Long getJoineeId() {
		return joineeId;
	}
	public void setJoineeId(Long joineeId) {
		this.joineeId = joineeId;
	}
	public String getJoineeName() {
		return joineeName;
	}
	public void setJoineeName(String joineeName) {
		this.joineeName = joineeName;
	}
	public String getJoineeemail() {
		return joineeemail;
	}
	public void setJoineeemail(String joineeemail) {
		this.joineeemail = joineeemail;
	}
	public String getJoineepassword() {
		return joineepassword;
	}
	public void setJoineepassword(String joineepassword) {
		this.joineepassword = joineepassword;
	}
	public String getJoineegender() {
		return joineegender;
	}
	public void setJoineegender(String joineegender) {
		this.joineegender = joineegender;
	}
	public Joinee() {
		super();
	
	}
	
	public Joinee(Long joineeId, String joineeName, String joineeemail, String joineepassword,
			String joineegender) {
		super();
		this.joineeId = joineeId;
		this.joineeName = joineeName;
		this.joineeemail = joineeemail;
		this.joineepassword = joineepassword;
		this.joineegender = joineegender;
	}
	
	@Override
	public String toString() {
		return "Ems22BeanPojo [joineeId=" + joineeId + ", joineeName=" + joineeName + ", joineeemail=" + joineeemail
				+ ", joineepassword=" + joineepassword + ", joineegender=" + joineegender + "]";
	}



}
