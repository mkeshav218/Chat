package com.chat.repo;

import com.chat.entity.Registration;
import com.chat.entity.RoomInfo;

public interface Repository {
	public void addRegistration(Registration newRegister);
	public String login(String emailId);
	public Registration getUserDetails(String emailId);
	public void addRoom(RoomInfo roomInfo);
	
}
