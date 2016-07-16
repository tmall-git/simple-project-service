package com.simple.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.dao.AgentSellerDao;
import com.simple.model.AgentSeller;
import com.simple.model.SellerJoinProductVO;
import com.simple.model.SellerJoinVO;


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
	
	public PageInfo<SellerJoinVO> getSellerJoinList(String userPhone, Integer pageIndex, Integer pageSize){
		PageHelper.startPage(pageIndex, pageSize);
		List<SellerJoinVO> headLists = dao.getSellerJoinHeadList(userPhone);
		String sqlPre = "(select p.owner userPhone, p.name productName, p.price, ROUND(p.price*";
		String sqlMid = " ,2) chargePrice, p.thumbnail from product p where p.owner = ";
		String sqlNext = " limit 2)";
		Integer headListSize = headLists.size();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < headListSize; i++) {
			SellerJoinVO sjhVO = headLists.get(i);
			sb.append(sqlPre).append(sjhVO.getChargePst()).append(sqlMid).append(sjhVO.getUserPhone()).append(sqlNext);
			if(i != headListSize -1){
				sb.append(" union ");
			}
		}
		List<SellerJoinProductVO> productLists = dao.getSellerJoinProductVO(sb.toString());
		for (SellerJoinVO headList : headLists) {
			List<SellerJoinProductVO> sjpList= new ArrayList<SellerJoinProductVO>();
			String phoneHead = headList.getUserPhone();
			for (SellerJoinProductVO productVO : productLists) {
				String phoneProduct = productVO.getUserPhone();
				if(phoneHead.equals(phoneProduct)){
					sjpList.add(productVO);
				}
			}
			headList.setLists(sjpList);
		}
		PageInfo<SellerJoinVO> page = new PageInfo<>(headLists);
		return page;
	}
}
