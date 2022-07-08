package com.chat.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.dto.CreateRoomDto;
import com.chat.dto.LoginDto;
import com.chat.entity.Registration;
import com.chat.entity.RoomInfo;
import com.chat.service.ProjectService;


@RestController
@CrossOrigin
public class ControllerImpl {
	
	@Autowired
	ProjectService service;

	@PostMapping(path="/user/registration")
	public String addRegistration(@RequestBody Registration newRegister) {
		boolean result = service.addRegistration(newRegister);
		if(result) {
			return "User Registration successful";	
		}else {
			return "User Registration failed";
		}
	}

	@PostMapping(path="/user/login")
	public String login(@RequestBody LoginDto loginDto) {
		try {
			if(service.login(loginDto.getEmailId(), loginDto.getPassword())) {
				return "Login successful";
			}else {
				return "Login Failed";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@PostMapping(path="/createroom")
	public String createRoom(@RequestBody CreateRoomDto createRoomDto) {
		try {
			if(service.login(createRoomDto.getEmailId(), createRoomDto.getPassword())) {
				Registration registration = service.getUserDetails(createRoomDto.getEmailId());
				System.out.println(registration);
				Set<Registration> registrations = new HashSet<>();
				registrations.add(registration);
				RoomInfo roomInfo = new RoomInfo();
				roomInfo.setRoomName(createRoomDto.getRoomName());
				roomInfo.setRegistration(registrations);
				boolean result = service.addRoom(roomInfo);
				if(result) {
					return "Room created successfully";	
				}else {
					return "Room Creation Failed";
				}
			}else {
				return "Room Creation Failed";
			}
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@PostMapping(path="/joinroom")
	public String joinRoom(@RequestBody CreateRoomDto createRoomDto) {
//		try {
//			if(service.login(createRoomDto.getEmailId(), createRoomDto.getPassword())) {
//				Registration registration = service.getUserDetails(createRoomDto.getEmailId());
//				Set<Registration> registrations = new HashSet<>();
//				registrations.add(registration);
//				RoomInfo roomInfo = new RoomInfo();
//				roomInfo.setRoomName(createRoomDto.getRoomName());
//				roomInfo.setRegistration(registrations);
//				boolean result = service.addRoom(roomInfo);
//				if(result) {
//					return "Room created successfully";	
//				}else {
//					return "Room Creation Failed";
//				}
//			}else {
//				return "Room Creation Failed";
//			}
//		}catch (Exception e) {
//			return e.getMessage();
//		}
		return null;
	}
	
}

