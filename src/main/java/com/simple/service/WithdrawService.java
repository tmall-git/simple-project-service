package com.simple.service;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.constant.Constant;
import com.simple.dao.UserDao;
import com.simple.dao.WithdrawDao;
import com.simple.model.Account;

@Service
public class WithdrawService {

	@Autowired
	private WithdrawDao withdrawDao;
	
	@Autowired
	private UserDao userDao;
	
	public void addAccount(Account account){
		withdrawDao.insert(account);
	}
	
	public Account queryById(String id) {
		return withdrawDao.queryById(id);
	}
	
	public Account updateAccountFinised(String id,String remark) {
		Account a = queryById(id);
		a.setOperateTime(new Timestamp(new Date().getTime()));
		a.setRemark(remark);
		a.setStatus(Constant.CASH_STATUS_FINISHED);
		withdrawDao.updateStatus(a);
		//扣掉余额
		userDao.reduceBlance(a.getUserPhone(), a.getCashAmount());
		return a;
	}
	
	public Account updateAccountCancel(String id,String remark) {
		Account a = queryById(id);
		a.setOperateTime(new Timestamp(new Date().getTime()));
		a.setRemark(remark);
		a.setStatus(Constant.CASH_STATUS_CANCEL);
		withdrawDao.updateStatus(a);
		return a;
	}

}
