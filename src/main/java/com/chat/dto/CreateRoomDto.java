package com.chat.dto;

public class CreateRoomDto {

	private String emailId;
	private String password;
	private String roomName;
	public CreateRoomDto() {
		super();
	}
	public CreateRoomDto(String emailId, String password, String roomName) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.roomName = roomName;
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
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
}
