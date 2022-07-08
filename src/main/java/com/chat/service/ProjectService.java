package com.chat.service;

import com.chat.entity.Registration;
import com.chat.entity.RoomInfo;

public interface ProjectService {

	public boolean addRegistration(Registration newRegister);
	public boolean login(String emailId,String password);
	public Registration getUserDetails(String emailId);

	public boolean addRoom(RoomInfo roomInfo);

}
