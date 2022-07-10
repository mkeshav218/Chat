package com.chat.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Registration")
@Component
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
	
	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "Registration_Room",
				joinColumns = @JoinColumn(name="emailId"),
				inverseJoinColumns = @JoinColumn(name="roomId"))
	private Set<RoomInfo> roomInfo = new HashSet<>();

	public Registration() {
		super();
	}

	public Registration(String emailId, String name, String contactNo, String password, Set<RoomInfo> roomInfo) {
		super();
		this.emailId = emailId;
		this.name = name;
		this.contactNo = contactNo;
		this.password = password;
		this.roomInfo = roomInfo;
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

	public Set<RoomInfo> getroomInfo() {
		return roomInfo;
	}

	public void addRoomInfo(RoomInfo roomInfo) {
		this.roomInfo.add(roomInfo);
	}

	@Override
	public String toString() {
		return "Registration [emailId=" + emailId + ", name=" + name + ", contactNo=" + contactNo + ", password="
				+ password + "]";
	}
	
}
