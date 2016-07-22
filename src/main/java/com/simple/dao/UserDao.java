package com.simple.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.simple.common.mybatis.annotation.DatabaseTemplate;
import com.simple.common.mybatis.dao.BaseIbatisDao;
import com.simple.constant.Constant;
import com.simple.model.User;

@Repository
@DatabaseTemplate("st_all")
public class UserDao extends BaseIbatisDao{
	
	public User getById(String statement, int id){
		return (User) super.getById(statement, id);
	}
	
	public User selectOne(String statement, Map<String, Object> params){
		User user = (User) super.selectOne(statement, params);
		return user;
	}
	
	public User getByPhone(String phone) {
		Map param = new HashMap();
		param.put("userPhone", phone);
		return this.sqlSession.selectOne("user.selectOne",param);
	}
	
	public void updateUserAllow(String phone,boolean allow) {
		Map param = new HashMap();
		param.put("userPhone", phone);
		if (allow) {
			param.put("allow", Constant.ALLOW_SELL);
		}else {
			param.put("allow", Constant.NOT_ALLOW_SELL);
		}
		this.sqlSession.update("user.updateAllow",param);
	}
	
	public void updatePercent(String phone,double percent) {
		Map param = new HashMap();
		param.put("userPhone", phone);
		param.put("percent", percent);
		this.sqlSession.update("user.updatePercent",param);
	}

}
