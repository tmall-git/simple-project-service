package com.simple.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.simple.common.mybatis.annotation.DatabaseTemplate;
import com.simple.common.mybatis.dao.BaseIbatisDao;
import com.simple.model.AgentSeller;
import com.simple.model.SellerJoinProductVO;
import com.simple.model.SellerJoinVO;

@Repository
@DatabaseTemplate("st_all")
public class AgentSellerDao extends BaseIbatisDao{
	
	public List<AgentSeller> queryByAgent(String phone){
		return this.sqlSession.selectList("agentSeller.queryByAgent",phone);
	}
	
	public List<AgentSeller> queryBySeller(String phone) {
		return this.sqlSession.selectList("agentSeller.queryBySeller",phone);
	}
	
	public int queryCountByAgent(String phone) {
		return this.sqlSession.selectOne("agentSeller.queryCountByAgent",phone);
	}
	
	public void add(AgentSeller agentSeller) {
		this.sqlSession.insert("agentSeller.insert",agentSeller);
	}
	
	public void delete(AgentSeller agentSeller) {
		this.sqlSession.insert("agentSeller.delete",agentSeller);
	}
	
	public void updatePercent(String agent,String seller,double percent) {
		Map param = new HashMap();
		param.put("chargePercent", percent);
		param.put("agentPhone", agent);
		param.put("sellerPhone", seller);
		this.sqlSession.update("agentSeller.updatePercent",param);
	}
	
	public List<SellerJoinVO> getSellerJoinHeadList(String userPhone){
		return this.sqlSession.selectList("agentSeller.getSellerJoinList", userPhone);
	}

	public List<SellerJoinProductVO> getSellerJoinProductVO(String sql) {
		return this.sqlSession.selectList("agentSeller.getSellerJoinProductList", sql);
	}
}
