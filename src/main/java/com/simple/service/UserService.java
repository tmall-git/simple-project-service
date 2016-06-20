package com.simple.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.dao.UserDao;
import com.simple.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	public User getById(String statement, int id){
		return dao.getById(statement, id);
	}
	
	public User selectOne(String statement, Map<String, Object> params){
		return dao.selectOne(statement, params);
	}

	public int insert(User user) {
		return dao.createObject("user.createRegister", user);
	}
	
	public int update(String statement, Map<String, Object> params){
		return dao.updateObject(statement, params);
	}

}
