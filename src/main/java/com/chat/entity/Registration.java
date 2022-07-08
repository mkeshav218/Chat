package com.chat.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="Registration")
public class Registration {
	@Id
	@Column(length=30)
	private String emailId;

	@Column(length=20)
	private String name;
	
	@Column(length=10)
	private String contactNo;
	
	@Column(length=20)
	private String password;
	
	@ManyToMany(mappedBy = "registration")
	private Set<RoomInfo> rommInfo;

	public Registration() {
		super();
	}

	public Registration(String emailId, String name, String contactNo, String password, Set<RoomInfo> rommInfo) {
		super();
		this.emailId = emailId;
		this.name = name;
		this.contactNo = contactNo;
		this.password = password;
		this.rommInfo = rommInfo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<RoomInfo> getRommInfo() {
		return rommInfo;
	}

	public void setRommInfo(Set<RoomInfo> rommInfo) {
		this.rommInfo = rommInfo;
	}

	@Override
	public String toString() {
		return "Registration [emailId=" + emailId + ", name=" + name + ", contactNo=" + contactNo + ", password="
				+ password + ", rommInfo=" + rommInfo + "]";
	}
	
}
