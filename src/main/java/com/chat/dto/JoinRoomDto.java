package com.chat.dto;

public class JoinRoomDto {

	private String emailId;
	private String password;
	private int roomId;
	public JoinRoomDto() {
		super();
	}
	
	public JoinRoomDto(String emailId, String password, int roomId) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.roomId = roomId;
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

	@Override
	public String toString() {
		return "JoinRoomDto [emailId=" + emailId + ", password=" + password + ", roomId=" + roomId + "]";
	}
	
}
