package com.chat.repo;

import java.util.List;
import java.util.Set;

import com.chat.entity.Registration;
import com.chat.entity.RoomInfo;

public interface Repository {
	public void addRegistration(Registration newRegister);
	public void updateRegistration(Registration newRegister);
	public String login(String emailId);
	public Registration getUserDetails(String emailId);
	public void addRoom(RoomInfo roomInfo);
	public RoomInfo getRoom(int roomId);
	public List<RoomInfo> getAllRoom();
	public Set<RoomInfo> getUserRooms(String emailId);
}
