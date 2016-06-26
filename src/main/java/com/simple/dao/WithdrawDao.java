package com.simple.dao;

import org.springframework.stereotype.Repository;

import com.simple.common.mybatis.annotation.DatabaseTemplate;
import com.simple.common.mybatis.dao.BaseIbatisDao;
import com.simple.model.Account;

@Repository
@DatabaseTemplate("st_all")
public class WithdrawDao extends BaseIbatisDao{

	public void insert(Account account){
		super.sqlSession.insert("account.insert", account);
	}
	
}
