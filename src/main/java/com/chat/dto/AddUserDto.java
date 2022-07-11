package com.chat.dto;

public class AddUserDto {

	private String emailId;
	private String password;
	private int roomId;
	private String userEmailId;
	public AddUserDto() {
		super();
	}
	public AddUserDto(String emailId, String password, int roomId, String userEmailId) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.roomId = roomId;
		this.userEmailId = userEmailId;
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
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	@Override
	public String toString() {
		return "AddUserDto [emailId=" + emailId + ", password=" + password + ", roomId=" + roomId + ", userEmailId="
				+ userEmailId + "]";
	}
	
	
}
