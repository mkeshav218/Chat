package com.chat.service;

import java.util.List;
import java.util.Set;

import com.chat.entity.Registration;
import com.chat.entity.RoomInfo;

public interface ProjectService {

	public boolean addRegistration(Registration newRegister);
	public boolean updateRegistration(Registration newRegister);

	public boolean login(String emailId,String password);
	public Registration getUserDetails(String emailId);

	public boolean addRoom(RoomInfo roomInfo);
	public RoomInfo getRoom(int roomId);
	public List<RoomInfo> getAllRoom();
	public Set<RoomInfo> getUserRooms(String emailId);

}
