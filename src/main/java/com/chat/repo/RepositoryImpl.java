package com.chat.repo;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.chat.entity.Registration;
import com.chat.entity.RoomInfo;

@org.springframework.stereotype.Repository
public class RepositoryImpl implements Repository {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void addRegistration(Registration newRegister) {
		entityManager.persist(newRegister);
	}
	
	@Transactional
	public void updateRegistration(Registration newRegister) {
		entityManager.merge(newRegister);
	}

	@Transactional
	public String login(String emailId) {
		Registration registerObj = entityManager.find(Registration.class, emailId);
		return registerObj.getPassword();
	}
	
	@Transactional
	public Registration getUserDetails(String emailId) {
		Registration registration = entityManager.find(Registration.class, emailId);
		return registration;
	}
	
	@Transactional
	public void addRoom(RoomInfo roomInfo) {
		entityManager.persist(roomInfo);
	}
	
	@Transactional 
	public RoomInfo getRoom(int roomId) {
		RoomInfo roomInfo = entityManager.find(RoomInfo.class, roomId);
		return roomInfo;
	}

	@Transactional
	public List<RoomInfo> getAllRoom(){
		String hql = "FROM RoomInfo";
		Query query = entityManager.createQuery(hql); 
		List<RoomInfo> allRooms = query.getResultList();
		return allRooms;
	}
	
	@Transactional
	public Set<RoomInfo> getUserRooms(String emailId){
		Registration reg = getUserDetails(emailId);
		return reg.getroomInfo();
	}
}
