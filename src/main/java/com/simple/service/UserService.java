package com.simple.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.dao.OrderDao;
import com.simple.dao.UserDao;
import com.simple.model.SellerListVO;
import com.simple.model.SellerMainVO;
import com.simple.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	@Autowired 
	private OrderDao orderDao;
	
	public User getById(String statement, int id){
		return dao.getById(statement, id);
	}
	
	public User selectOne(String statement, Map<String, Object> params){
		return dao.selectOne(statement, params);
	}

	public User queryByPhone(String phone) {
		return dao.getByPhone(phone);
	}
	
	public int insert(User user) {
		return dao.createObject("user.createRegister", user);
	}
	
	public int update(User user){
		return dao.updateObject("user.modify",user);
	}

	public Map<String, Object> toSellerMain(User user) {
		/*SELECT SUM(o.total_price) totalPrice, SUM(o.total_charge) totalCharge, 
			COUNT(DISTINCT owner) ownerCount, SUM(IF(o.order_status = 1 OR o.order_status = 2,1,0)) trading, 
			SUM(IF(o.reject_status = 1,1,0)) rejectCount
		FROM tmall_order o
		WHERE order.seller = #{userPhone}*/
		Map<String, Object> mainVO = new HashMap<String, Object>();
		SellerMainVO vo = new SellerMainVO();
		// 头部
		Map<String, Object> headMap = orderDao.getTotalSellerAmount(user);
		vo.setTotalSellAmount(Double.valueOf(headMap.get("totalPrice").toString()));
		vo.setTotalChargeAmount(Double.valueOf(headMap.get("totalCharge").toString()));
		vo.setBalance(user.getBalance());
		// 当前订单
		vo.setTradingOrderCount(Integer.valueOf(headMap.get("trading").toString()));
		vo.setReturningOrderCount(Integer.valueOf(headMap.get("rejectCount").toString()));
		//店铺总数
		vo.setOwnerCount(Integer.valueOf(headMap.get("ownerCount").toString()));
		// 店铺列表
		List<SellerListVO> sellerListVO = orderDao.getSellerList(user);
		mainVO.put("main", vo);
		mainVO.put("lists", sellerListVO);
		return mainVO;
	}
}
