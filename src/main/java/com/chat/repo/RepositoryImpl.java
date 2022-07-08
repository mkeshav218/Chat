package com.chat.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
