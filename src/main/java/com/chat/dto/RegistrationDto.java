package com.chat.dto;

public class RegistrationDto {
	
	private String name;
	private String contactNo;
	private String emailId;
	private String password;
	public RegistrationDto() {
		super();
	}
	public RegistrationDto(String name, String contactNo, String emailId, String password) {
		super();
		this.name = name;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.password = password;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "RegistrationDto [name=" + name + ", contactNo=" + contactNo + ", emailId=" + emailId + ", password="
				+ password + "]";
	}
	
}
