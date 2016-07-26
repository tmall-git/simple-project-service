package com.simple.service;

//import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
import com.simple.dao.OrderDao;
import com.simple.dao.UserDao;
//import com.simple.model.SellerListVO;
import com.simple.model.SellerMainVO;
import com.simple.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	@Autowired 
	private OrderDao orderDao;
	
	public User getById(String statement, int id){
		return dao.getById(statement, id);
	}
	
	public User selectOne(String statement, Map<String, Object> params){
		return dao.selectOne(statement, params);
	}

	public User queryByPhone(String phone) {
		return dao.getByPhone(phone);
	}
	
	public int insert(User user) {
		return dao.createObject("user.createRegister", user);
	}
	
	public int update(User user){
		return dao.updateObject("user.modify",user);
	}

}
