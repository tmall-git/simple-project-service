package com.simple.dao;

import java.util.List;

import com.simple.common.mybatis.dao.BaseIbatisDao;
import com.simple.model.Bank;

public class BaseDao extends BaseIbatisDao{

	private String scope = "base.";
	
	public List<Bank> getBankList(){
		return super.sqlSession.selectList(scope + "getBankList");
	}
}
