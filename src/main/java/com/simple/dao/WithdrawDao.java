package com.simple.dao;

import org.springframework.stereotype.Repository;

import com.simple.common.mybatis.annotation.DatabaseTemplate;
import com.simple.common.mybatis.dao.BaseIbatisDao;
import com.simple.model.Account;

@Repository
@DatabaseTemplate("st_all")
public class WithdrawDao extends BaseIbatisDao{

	public void insert(Account account){
		this.sqlSession.insert("account.insert", account);
	}
	
	public Account queryById(String id){
		return this.sqlSession.selectOne("account.getById", id);
	}
	
	public void updateStatus(Account account){
		this.sqlSession.update("account.updateStatus", account);
	}
	
}
