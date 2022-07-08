package com.chat.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="RoomInfo")
public class RoomInfo {

	@Id
	@Column(length=20)
	private String roomName;
	
	@ManyToMany
	private Set<Registration> registration;

	public RoomInfo() {
		super();
	}

	public RoomInfo(int roomNo, String roomName, Set<Registration> registration) {
		super();
		this.roomName = roomName;
		this.registration = registration;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Set<Registration> getRegistration() {
		return registration;
	}

	public void setRegistration(Set<Registration> registration) {
		this.registration = registration;
	}

	@Override
	public String toString() {
		return "RoomInfo [roomName=" + roomName + ", registration=" + registration + "]";
	}

}
