package com.simple.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.simple.dao.UserDao;
import com.simple.dao.WithdrawDao;
import com.simple.model.Account;
import com.simple.model.User;

public class WithdrawService {

	@Autowired
	private WithdrawDao withdrawDao;
	
	@Autowired
	private UserDao userDao;
	
	public boolean addAccount(Account account){
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userPhone", account.getUserPhone());
			User user = userDao.selectOne("user.selectOne", params);
			double balance = user.getBalance();
			account.setCashAmount(balance);
			account.setCashTime(new Date());
			withdrawDao.insert(account);
			user.setBalance(user.getBalance()-account.getCashAmount());
			userDao.updateObject("user.modify",user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
