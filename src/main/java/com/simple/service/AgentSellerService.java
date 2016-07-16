package com.simple.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.dao.AgentSellerDao;
import com.simple.model.AgentSeller;
import com.simple.model.SellerJoinHeadVO;
import com.simple.model.SellerJoinProductVO;


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
	
	public List<Map<String, Object>> getSellerJoinList(String userPhone){
		List<SellerJoinHeadVO> headLists = dao.getSellerJoinHeadList(userPhone);
		String sqlPre = "select p.owner,p.name,p.price,ROUND(p.price*";
		String sqlMid = " ,2) chargePrice, p.thumbnail from product p where p.owner = ";
		String sqlEnd = " limit 2";
		Integer headListSize = headLists.size();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < headListSize; i++) {
			SellerJoinHeadVO sjhVO = headLists.get(i);
			sb.append(sqlPre).append(sjhVO.getChargePst()).append(sqlMid).append(sjhVO.getUserPhone()).append(sqlEnd);
			if(i != headListSize -1){
				sb.append(" union ");
			}
		}
		List<SellerJoinProductVO> productLists = dao.getSellerJoinProductVO(sb.toString());
		List<Map<String, Object>> resultVO = new ArrayList<Map<String,Object>>();
		for (SellerJoinHeadVO headList : headLists) {
			Map<String, Object> resultMap = new HashMap<String, Object>();
			List<SellerJoinProductVO> sjpList= new ArrayList<SellerJoinProductVO>();
			String phoneHead = headList.getUserPhone();
			for (SellerJoinProductVO productVO : productLists) {
				String phoneProduct = productVO.getUserPhone();
				if(phoneHead.equals(phoneProduct)){
					sjpList.add(productVO);
				}
			}
			resultMap.put("headList", headList);
			resultMap.put("productList", sjpList);
			resultVO.add(resultMap);
		}
		return resultVO;
	}
}
