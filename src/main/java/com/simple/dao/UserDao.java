package com.simple.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.simple.common.mybatis.annotation.DatabaseTemplate;
import com.simple.common.mybatis.dao.BaseIbatisDao;
import com.simple.model.User;

@Repository
@DatabaseTemplate("st_all")
public class UserDao extends BaseIbatisDao{
	
	public User getById(String statement, int id){
		return (User) super.getById(statement, id);
	}
	
	public User selectOne(String statement, Map<String, Object> params){
		User user = null;
		try {
			user = (User) super.selectOne(statement, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public int insert(String statement, Map<String, Object> params) {
		return super.createObject(statement, params);
	}
	
	public int update(String statement, Map<String, Object> params){
		return super.updateObject(statement, params);
	}

}
