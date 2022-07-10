package com.chat.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.entity.Registration;
import com.chat.entity.RoomInfo;
import com.chat.repo.Repository;

@Service
public class ServiceImpl implements ProjectService {

	@Autowired
	Repository repo;


	@Override
	public boolean addRegistration(Registration newRegister) {
		try {
			repo.addRegistration(newRegister);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean updateRegistration(Registration newRegister) {
		try {
			repo.updateRegistration(newRegister);
			return true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean login(String emailId,String password) {
		try {
			String storedPassword = repo.login(emailId);
			if(password.equals(storedPassword)) {
				return true;//"Password Matched";
			}else {
				throw new RuntimeException("Password doesn't Matched");
			}
		}catch (Exception e) {
			if(e.getMessage()==null)
				throw new RuntimeException("User account not found");
			else {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
	@Override
	public Registration getUserDetails(String emailId) {
		return repo.getUserDetails(emailId);
	}
	
	@Override
	public boolean addRoom(RoomInfo roomInfo) {
		try {
			repo.addRoom(roomInfo);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public RoomInfo getRoom(int roomId) {
		return repo.getRoom(roomId);
	}
	
	@Override
	public List<RoomInfo> getAllRoom(){
		return repo.getAllRoom();
	}
	
	@Override
	public Set<RoomInfo> getUserRooms(String emailId){
		return repo.getUserRooms(emailId);
	}
}
