package com.simple.dao;

import com.simple.common.mybatis.dao.BaseIbatisDao;
import com.simple.model.Account;

public class WithdrawDao extends BaseIbatisDao{

	public void insert(Account account){
		super.sqlSession.insert("account.insert", account);
	}
	
}
