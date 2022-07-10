package com.chat.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="RoomInfo")
public class RoomInfo {

	@Id
	@Column(length=20)
	@GeneratedValue
	private int roomId;
	
	@Column(length=20)
	private String roomName;
	
	@ManyToMany(mappedBy = "roomInfo")
	@JsonIgnore
	private Set<Registration> registration = new HashSet<>();

	public RoomInfo() {
		super();
	}

	public RoomInfo(int roomId, String roomName, Set<Registration> registration) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.registration = registration;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
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

	public void addRegistration(Registration registration) {
		this.registration.add(registration);
	}

	@Override
	public String toString() {
		return "RoomInfo [roomId=" + roomId + ", roomName=" + roomName + "]";
	}

}
