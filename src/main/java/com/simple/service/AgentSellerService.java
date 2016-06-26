package com.simple.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.dao.AgentSellerDao;
import com.simple.model.AgentSeller;
import com.simple.model.User;

@Service
public class AgentSellerService {
	
	@Autowired
	private AgentSellerDao dao;
	
	public List<AgentSeller> queryByAgent(String phone){
		return dao.queryByAgent(phone);
	}
	
	public List<AgentSeller> queryBySeller(String phone) {
		return dao.queryBySeller(phone);
	}
	
	public int queryCountByAgent(String phone) {
		return dao.queryCountByAgent(phone);
	}
	
	public void add(AgentSeller agentSeller) {
		dao.add(agentSeller);
	}
	
	public void delete(AgentSeller agentSeller) {
		dao.delete(agentSeller);
	}
	
	public void updatePercent(String agent,String seller,double percent) {
		dao.updatePercent(agent, seller, percent);
	}
}
