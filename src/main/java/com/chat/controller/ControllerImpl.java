package com.chat.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.dto.CreateRoomDto;
import com.chat.dto.JoinRoomDto;
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
				RoomInfo roomInfo = new RoomInfo();
				roomInfo.setRoomName(createRoomDto.getRoomName());
				boolean isRoomAdded = service.addRoom(roomInfo);
				if(isRoomAdded) {
					Registration registration = service.getUserDetails(createRoomDto.getEmailId());
					registration.getroomInfo().add(roomInfo);
					service.updateRegistration(registration);
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
	public String joinRoom(@RequestBody JoinRoomDto joinRoomDto) {
		try {
			if(service.login(joinRoomDto.getEmailId(), joinRoomDto.getPassword())) {
				Registration registration = service.getUserDetails(joinRoomDto.getEmailId());
				RoomInfo roomInfo = service.getRoom(joinRoomDto.getRoomId());
				registration.getroomInfo().add(roomInfo);
				boolean result = service.updateRegistration(registration);
				if(result) {
					return "Room joined successfully";	
				}else {
					return "Room joined Failed";
				}
			}else {
				return "Room joined Failed";
			}
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@PostMapping(path="/leaveroom")
	public String leaveRoom(@RequestBody JoinRoomDto joinRoomDto) {
		try {
			if(service.login(joinRoomDto.getEmailId(), joinRoomDto.getPassword())) {
				Registration registration = service.getUserDetails(joinRoomDto.getEmailId());
				RoomInfo roomInfo = service.getRoom(joinRoomDto.getRoomId());
				registration.getroomInfo().remove(roomInfo);
				boolean result = service.updateRegistration(registration);
				if(result) {
					return "Leaved Room successfully";	
				}else {
					return "Leave Room Failed";
				}
			}else {
				return "Leave Room Failed";
			}
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@PostMapping(path="/getallroom")
	public List<RoomInfo> getAllRoom(@RequestBody LoginDto loginDto) {
		try {
			if(service.login(loginDto.getEmailId(), loginDto.getPassword())) {
				return service.getAllRoom();
			}else {
				return null;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@PostMapping(path="/getuserrooms")
	public Set<RoomInfo> getUserRooms(@RequestBody LoginDto loginDto) {
		try {
			if(service.login(loginDto.getEmailId(), loginDto.getPassword())) {
				return service.getUserRooms(loginDto.getEmailId());
			}else {
				return null;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}

